public void connect(String ticketName) throws Exception {
             if (prop != null) {
                   ConnectionFactoryASI.setProtocol(prop);
                   ConnectionFactoryASI.setDataObjectFactoryType(prop);
                   serviceFactory = ConnectionFactoryASI.getServiceFactory(prop, ticketName);
             } else {
                   serviceFactory = ConnectionFactoryASI.getServiceFactory(ticketName, user);
             }
             dataObjectFactory = serviceFactory.getDataObjectFactory();
            setUser(serviceFactory.getClientSession().getLoginName());
             logger.debug("ASI HostName: " + serviceFactory.getClientSession().getHostName()
                          + ", DatabaseName: " + serviceFactory.getClientSession().getDatabaseName()
                          + ", DbHostName: " + serviceFactory.getClientSession().getDbHostName());
      }