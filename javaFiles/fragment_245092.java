public class FusekiTestServer {
    public static void main(String[] args) {
        Dataset ds = DatasetFactory.createTxnMem() ;

        FusekiEmbeddedServer server = FusekiEmbeddedServer.create()
                .setPort(3333)
                .add("/ds", ds, true)
                .build() ;
        server.start() ;
    }
}