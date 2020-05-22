private XMPPConnection connect() throws XMPPException, SmackException,
        IOException {
    if ((this.connection != null) && (this.connection.isConnected())) {
        return this.connection;
    }

    ConnectionConfiguration config = new ConnectionConfiguration(HOST1,
            5222);
    SmackConfiguration.DEBUG_ENABLED = true;
    SASLAuthentication.supportSASLMechanism("MD5", 0);
    System.setProperty("smack.debugEnabled", "true");
    config.setCompressionEnabled(false);
    config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
    config.setReconnectionAllowed(true);
    config.setSendPresence(true);
    config.setRosterLoadedAtLogin(true);

    if (Build.VERSION.SDK_INT >= 14) {
        config.setKeystoreType("AndroidCAStore");
        config.setKeystorePath(null);
    } else {
        config.setKeystoreType("BKS");
        String str = System.getProperty("javax.net.ssl.trustStore");
        if (str == null) {
            str = System.getProperty("java.home") + File.separator + "etc"
                    + File.separator + "security" + File.separator
                    + "cacerts.bks";
        }
        config.setKeystorePath(str);
    }
    if (connection == null) {
        this.connection = new XMPPTCPConnection(config);
    }
    this.connection.connect();
    Roster roster = connection.getRoster();
    roster.addRosterListener(new RosterListener() {

        @Override
        public void presenceChanged(Presence arg0) {
            Log.d("deb", "ug");
        }

        @Override
        public void entriesUpdated(Collection<String> arg0) {
            Log.d("deb", "ug");
        }

        @Override
        public void entriesDeleted(Collection<String> arg0) {
            Log.d("deb", "ug");
        }

        @Override
        public void entriesAdded(Collection<String> arg0) {
            Log.d("deb", "ug");
        }
    });
    return this.connection;
}