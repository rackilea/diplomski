URI baseUri = UriBuilder.fromUri("http://localhost/api")
                        .port(8081)
                        .build();

ResourceConfig rc = new PackagesResourceConfig("se.aioobe.resources");

// Add AuthFilter ////////////
rc.getProperties().put("com.sun.jersey.spi.container.ContainerRequestFilters",
                       "<YOUR PACKAGE FOR AuthFilter>.AuthFilter");
//////////////////////////////

HttpServer httpServer = GrizzlyServerFactory.createHttpServer(baseUri, rc);