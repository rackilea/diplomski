@Before
    public void setup() throws Exception {
        if (server == null) {
            System.out.println("Initializing an instance of Grizzly Container ...");
            final ResourceConfig rc = new ResourceConfig(ResourceEndpointIntegrationTest.class, ..., ..., ...); //update

            WebappContext ctx = new WebappContext("IntegrationTestContext");
                        //register your listeners from web.xml in here
            ctx.addListener("com.xxx.yyy.XEndpointServletContextListener");
                        //register your applicationContext.xml here
            ctx.addContextInitParameter("contextConfigLocation", "classpath:applicationContext.xml");

                        //ServletRegistration is needed to load the ResourceConfig rc inside ServletContainer or you will have no 
                        //Servlet-based features available 
            ServletRegistration registration = ctx.addServlet("ServletContainer",
                    new ServletContainer(rc));

                        //Initialize the Grizzly server passing it base URL
            server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI));

                        //Deploy the server using our custom context
            ctx.deploy(server);
        }
    }