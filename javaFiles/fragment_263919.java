VertxOptions options = new VertxOptions();

    Config config = new Config();
    NetworkConfig networkConfig = config.getNetworkConfig();

    networkConfig.getInterfaces().setEnabled(true).addInterface(args[0]);
    options.setClusterManager(new HazelcastClusterManager(config));
    options.setClustered(true);
    options.setClusterHost(args[0]);

    Vertx.clusteredVertx(options, res -> {
        Vertx vertx = res.result();
        vertx.deployVerticle(new Receiver());

    });