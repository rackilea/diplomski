ServiceLocator serviceLocator = SLF.getInstance().create(...);
ServiceLocatorUtilities.bind(serviceLocator, new Binder1(), new Binder2());
App app = new App();
serviceLocator.inject(app);
HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
        URI.create(BASE_URI),
        resourceConfig, 
        serviceLocator
);