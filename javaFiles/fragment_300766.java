// add all bundles to the bundles variable including the Liquibase bundle. 
// registers guice with dropwizard
        bootstrap.addBundle(GuiceBundle.<EngineConfigurationImpl>builder()
                .enableAutoConfig("my.package")
                .searchCommands(true)    
                .bundles(bundles.toArray( new GuiceyBundle[0]))
                .modules(getConfigurationModule(), new CoreModule())
                                   .build()
        );