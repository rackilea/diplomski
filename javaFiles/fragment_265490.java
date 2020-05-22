RequestUpgradeStrategy upgradeStrategy = new TomcatRequestUpgradeStrategy();
registry.addEndpoint("/hello")
        .withSockJS();

registry.addEndpoint("/hello")
        .setHandshakeHandler(new DefaultHandshakeHandler(upgradeStrategy))
        .setAllowedOrigins("*");