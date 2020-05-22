public class CreateRelationsRunner implements Runnable {

    private GraphDatabaseService graphDb;
    private List<Thing> things;

    public CreateRelationsRunner(GraphDatabaseService graphDb, List<Thing> things) {
        this.graphDb = graphDb;
        this.things = things;
    }

    @Override
    public void run() {

        try (Transaction tx = graphDb.beginTx()) {
            for(Thing tFrom : things) {

                List<ValuePair> relations = tFrom.getRelations();

                Label label = tFrom.getLabel();
                Node firstNode = graphDb.findNode(label, "uid", tFrom.getUid());

                for(ValuePair vp : relations) {
                    Thing tTo = (Thing) vp.getValue();

                    label = tTo.getLabel();
                    Node secondNode = graphDb.findNode(label, "uid", tTo.getUid());

                    RelationshipType relType = vp.getRelationshipType();
                    firstNode.createRelationshipTo(secondNode, relType);

                }
            }

            tx.success();
        }

    }
}