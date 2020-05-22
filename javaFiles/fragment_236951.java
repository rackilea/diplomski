public class CassandraAstyanaxConnection {

    private CassandraAstyanaxConnection(){ }        

    private static class Holder {
       private static final CassandraAstyanaxConnection INSTANCE = new CassandraAstyanaxConnection();
    }

    public static CassandraAstyanaxConnection getInstance() {
        return Holder.INSTANCE;
    }
    // rest of class omitted
}