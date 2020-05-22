try {
  // Create a connection factory
  JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
  JmsConnectionFactory cf = ff.createConnectionFactory();

  // Set the properties
  cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, "localhost");
  cf.setIntProperty(WMQConstants.WMQ_PORT, 1414);
  cf.setStringProperty(WMQConstants.WMQ_CHANNEL, "SYSTEM.DEF.SVRCONN");
  cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
  cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, "QM1");