XMPPTCPConnectionConfiguration conf = XMPPTCPConnectionConfiguration.builder()
            .setServiceName(SERVICE_NAME)
            .setHost(HOST_NAME)
            .setPort(5222)
            .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
            .build();

AbstractXMPPConnection connection = new XMPPTCPConnection(conf);
connection.connect(); // Here we create the connection

// Now we create the account:
AccountManager accountManager = AccountManager.getInstance(connection);
accountManager.createAccount(username, password);

// The account has been created, so we can now login
connection.login(username, password);