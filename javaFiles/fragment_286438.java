public class CreateNodeRunner implements Runnable {

    private List<Thing> things;
    private GraphDatabaseService graphDb;

    public CreateNodeRunner(GraphDatabaseService graphDb, List<Thing> things) {
        this.things = things;
        this.graphDb = graphDb;
    }

    @Override
    public void run() {

        try (Transaction tx = graphDb.beginTx()) {

            for(Thing t : things) {
                Node node = graphDb.createNode(t.getLabel());
                node.setProperty("uid", t.getUid());

                for (ValuePair vp : t.getProperties()) {
                    node.setProperty(vp.getName(), vp.getValue());
                }
            }
            tx.success();
        }
    }
}