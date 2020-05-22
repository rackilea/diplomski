@Override
public void run(String... strings) throws Exception {
    // used for Neo4j browser
    try {
        WrappingNeoServerBootstrapper neoServerBootstrapper;
        GraphDatabaseAPI api = (GraphDatabaseAPI) db;

        ServerConfigurator config = new ServerConfigurator(api);
        config.configuration()
            .addProperty(Configurator.WEBSERVER_ADDRESS_PROPERTY_KEY, "127.0.0.1");
        config.configuration()
            .addProperty(Configurator.WEBSERVER_PORT_PROPERTY_KEY, "8686");

        neoServerBootstrapper = new WrappingNeoServerBootstrapper(api, config);
        neoServerBootstrapper.start();
    } catch(Exception e) {
        //handle appropriately
    }
    // end of Neo4j browser config
}