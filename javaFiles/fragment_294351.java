FileConfiguration configuration = new FileConfiguration();
configuration.setConfigurationUrl("hornetq-configuration.xml");

configuration.start(); // <<<-----------------

// Prepare configuration objects
String netty = NettyAcceptorFactory.class.getName();
Map<String, Object> transportParams = new HashMap<String, Object>();
transportParams.put(TransportConstants.HOST_PROP_NAME, "localhost");
transportParams.put(TransportConstants.PORT_PROP_NAME, 6446);
TransportConfiguration transpConf = new TransportConfiguration(netty, transportParams);

configuration.getAcceptorconfigurations().clear(); // <<<-----------------

// add configuration
configuration.getAcceptorConfigurations().add(transpConf);