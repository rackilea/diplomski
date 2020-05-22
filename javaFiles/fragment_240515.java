Properties connectProps = new Properties();
connectProps.setProperty(AdminClient.CONNECTOR_TYPE,
    AdminClient.CONNECTOR_TYPE_SOAP);
connectProps.setProperty(AdminClient.CONNECTOR_HOST,"localhost");
connectProps.setProperty(AdminClient.CONNECTOR_PORT,"8880");
AdminClient adminClient=AdminClientFactory.createAdminClient(connectProps);
ConfigService service=new ConfigServiceProxy(adminClient);