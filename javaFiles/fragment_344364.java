// start client
client = CuratorFrameworkFactory.builder()
    .connectString("localhost:2181")
    .retryPolicy(new ExponentialBackoffRetry(1000, 3))
    .namespace("heavenize")
    .build();

client.getConnectionStateListenable().addListener(new ConnectionStateListener() {      
  @Override
  public void stateChanged(CuratorFramework client, ConnectionState newState)
  {
    log.info("State changed to: "+newState);
  }
});
}