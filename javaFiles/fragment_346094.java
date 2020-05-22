// based on the above keyspace, we would change the cluster and session as follows:
Cluster cluster = Cluster.builder()
  .addContactPoints(serverIP)
  .build();
Session session = cluster.connect("exampkeyspace");

String cqlStatement = "CREATE TABLE users (" + 
                      " username varchar PRIMARY KEY," + 
                      " password varchar " + 
                      ");";

session.execute(cqlStatement);