Properties startupProperties = ...

QuorumPeerConfig quorumConfiguration = new QuorumPeerConfig();
try {
    quorumConfiguration.parseProperties(startupProperties);
} catch(Exception e) {
    throw new RuntimeException(e);
}

zooKeeperServer = new ZooKeeperServerMain();
final ServerConfig configuration = new ServerConfig();
configuration.readFrom(quorumConfiguration);

new Thread() {
    public void run() {
        try {
            zooKeeperServer.runFromConfig(configuration);
        } catch (IOException e) {
            log.error("ZooKeeper Failed", e);
        }
    }
}.start();