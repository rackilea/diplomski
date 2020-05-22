// Run the server bound to the local machine IP
String hostAddress = InetAddress.getLocalHost().getHostAddress();

// No implementation here?????
Config applicationConfig = ConfigFactory.load();
ActorSystem system =  ActorSystem.create("HttpProxy", applicationConfig);
final ActorMaterializer materializer = ActorMaterializer.create(system);


// todo: missing handler, settings, httpsContext and log
Flow<HttpRequest, HttpResponse, ?> handler;
ServerSettings settings;
akka.japi.Option<HttpsContext> httpsContext;
LoggingAdapter log;
Http.get(system).bindAndHandle(handler, hostAddress, 9000, settings, httpsContext, log, materializer);

System.out.println("Starting server on " + hostAddress + ":" + 9000);