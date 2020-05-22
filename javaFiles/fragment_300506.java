public static void main(String[] Args)
{
    Cluster cluster = null;
    cluster = Cluster.builder()
                     .addContactPoint("127.0.0.1")
                     .build();
    Session session = cluster.connect();

    try
    {
        String createKS = "CREATE KEYSPACE test WITH REPLICATION = { 'class': 'SimpleStrategy', 'replication_factor': '2' }";
        session.execute(createKS);
        String query = "create table test.user (username text primary key,first text, last text);";
        session.execute(query);

        System.out.println("insert executed");
        Insert insert = QueryBuilder.insertInto("test", "user")
                                    .value("username", "jdoe")
                                    .value("first", "John")
                                    .value("last", "Doe");
        System.out.println(insert.toString());
        ResultSet result = session.execute(insert.toString());
        System.out.println(result);
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }

    System.exit(0);
}