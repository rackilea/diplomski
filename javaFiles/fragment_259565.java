public class MyService {
    private Cluster cluster;
    private Session session;
    private PreparedStatement query;

     // exception handling not included to keep the code short
    public void init() {
        cluster = Cluster.builder()
            .addContactPoints("52.36.24.246").withPort(9042)
            .withQueryOptions(new QueryOptions().setFetchSize(2000))
            .withCredentials("username", "password")
            .build();
        session = cluster.connect();
        query = session.prepare("SELECT * FROM godfather.crime WHERE psa= ?");
    }

    public String execQuery(int psa) {
        for(Row r : session.execute(prepared.bind(psa))) {
            // your processing here
        }
    }