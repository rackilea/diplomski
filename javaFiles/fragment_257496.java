final ServiceLocator serviceLocator = MavenRepositorySystemUtils.newServiceLocator()
        .addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class)
        .addService(TransporterFactory.class, FileTransporterFactory.class)
        .addService(TransporterFactory.class, HttpTransporterFactory.class);

 // ...
container.addComponent(serviceLocator.lookup(RepositorySystem.class)
    , RepositorySystem.class
    , "default");
container.addComponent(serviceLocator.lookup(RemoteRepositoryManager.class)
    , RemoteRepositoryManager.class
    , "default");