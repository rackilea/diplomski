public class NeoTraversal {

public static void main(final String[] args) {
    final GraphDatabaseService db = new GraphDatabaseFactory()
            .newEmbeddedDatabaseBuilder("/neo4j")
            .loadPropertiesFromURL(NeoTraversal.class.getClassLoader().getResource("neo4j.properties"))
            .newGraphDatabase();
    final Set<Long> uniquePartnerRels = new HashSet<Long>();
    long startTime = System.currentTimeMillis();
    final Node start = db.getNodeById(36);
    for (final Path path : Traversal.description()
            .breadthFirst()
            .relationships(Rel.COOCCURS_WITH, Direction.BOTH)
            .uniqueness(Uniqueness.NODE_GLOBAL)
            .evaluator(Evaluators.atDepth(1))
            .traverse(start)) {
        Node partner = start.equals(path.startNode()) ? path.endNode() : path.startNode();
        for (final Path partnerPath : Traversal.description()
                .depthFirst()
                .relationships(Rel.COOCCURS_WITH, Direction.BOTH)
                .uniqueness(Uniqueness.RELATIONSHIP_PATH)
                .evaluator(Evaluators.atDepth(2))
                .evaluator(Evaluators.includeWhereEndNodeIs(start))
                .traverse(partner)) {
            uniquePartnerRels.add(partnerPath.relationships().iterator().next().getId());
        }
    }
    System.out.println("Execution time: " + (System.currentTimeMillis() - startTime));
    System.out.println(uniquePartnerRels.size());
}

static enum Rel implements RelationshipType {
    COOCCURS_WITH
}

}