public class CreateManyRelationships {

    public static final int COUNT = 1000 * 1000;
    public static final DynamicRelationshipType CHILD = DynamicRelationshipType.withName("CHILD");
    public static final File DIRECTORY = new File("target/test.db");

    public static void main(String[] args) throws IOException {
        FileUtils.deleteRecursively(DIRECTORY);
        GraphDatabaseService gdb = new GraphDatabaseFactory().newEmbeddedDatabase(DIRECTORY.getAbsolutePath());
        long time=System.currentTimeMillis();
        Transaction tx = gdb.beginTx();
        Node root = gdb.createNode();
        for (int i=1;i<= COUNT;i++) {
            Node child = gdb.createNode();
            root.createRelationshipTo(child, CHILD);
            if (i % 50000 == 0) {
                tx.success();tx.finish();
                tx = gdb.beginTx();
            }
        }
        tx.success();tx.finish();
        time = System.currentTimeMillis()-time;
        System.out.println("import of "+COUNT+" children took " + time/1000 + " seconds.");
        gdb.shutdown();
    }
}