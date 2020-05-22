server = new Server(config.getServer().getPort());

RewriteHandler rewriteHandler = new RewriteHandler();
rewriteHandler.setRewriteRequestURI(true);
rewriteHandler.setRewritePathInfo(false);
rewriteHandler.setOriginalPathAttribute("requestedPath");

RewriteRegexRule rule1 = new RewriteRegexRule();
rule1.setRegex("^((?!"+wsPath+"|\\.js|\\.css|\\.jpe?g|\\.png).)*$");
rule1.setReplacement("/index.html");
rewriteHandler.addRule(rule1);

URL webRootLocation = this.getClass().getResource("/frontend/index.html");
if (webRootLocation == null)
    throw new IllegalStateException("Unable to determine Web-Root URL location");

URI webRootUri = URI.create(webRootLocation.toURI().toASCIIString().replaceFirst("/index.html$","/"));
logger.debug("Web-Root URI: {}",webRootUri);

ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
contextHandler.setContextPath("/");
contextHandler.setBaseResource(Resource.newResource(webRootUri));
contextHandler.setWelcomeFiles(new String[]{ "index.html" });

rewriteHandler.setHandler(contextHandler);

// Initialize WebSocket
ServerContainer container = WebSocketServerContainerInitializer.initialize(contextHandler);

List<Class<? extends Encoder>> encoders = new ArrayList<>();
encoders.add(MessageEncoder.class);
List<Class<? extends Decoder>> decoders = new ArrayList<>();
decoders.add(MessageDecoder.class);

ServerEndpointConfig endpointConfig = ServerEndpointConfig.Builder
        .create(AppEndpoint.class, "/" + wsPath)
        .encoders(encoders)
        .decoders(decoders)
        .configurator(new AppEndpointConfig(config, factory))
        .build();
container.addEndpoint(endpointConfig);

server.setHandler(rewriteHandler);

contextHandler.addServlet(DefaultServlet.class, "/");

server.start();
server.join();