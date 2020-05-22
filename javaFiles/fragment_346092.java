String serverIP = "127.0.0.1";
String keyspace = "system";

Cluster cluster = Cluster.builder()
  .addContactPoints(serverIP)
  .build();

Session session = cluster.connect(keyspace);

// you are now connected to the cluster, congrats!