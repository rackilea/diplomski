ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration("localhost", 5222);
connectionConfiguration.setSecurityMode(ConnectionConfiguration.SecurityMode.required);
connectionConfiguration.setSASLAuthenticationEnabled(true);
connectionConfiguration.setKeystorePath("src/main/resources/bogus_mina_tls.cert");
connectionConfiguration.setTruststorePath("src/main/resources/bogus_mina_tls.cert");
connectionConfiguration.setTruststorePassword("boguspw");