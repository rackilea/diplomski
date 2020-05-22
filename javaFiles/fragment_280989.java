@Test
public void testTraversal() throws Exception {
    GraphDatabaseService db = new TestGraphDatabaseFactory().newImpermanentDatabase();
    List<Node> nodes = new ArrayList<>();
    int count=0;
    long now = System.currentTimeMillis();
    try (Transaction tx = db.beginTx()) {
        for (int i=0;i<400;i++) {
            nodes.add(db.createNode());
        }
        DynamicRelationshipType knows = DynamicRelationshipType.withName("KNOWS");
        for (Node node1 : nodes) {
            for (Node node2 : nodes) {
                double random = Math.random();
                if (random < 0.1 && node1 != node2) {
                    node1.createRelationshipTo(node2, knows).setProperty("weight",random);
                    count++;
                }
            }
        }
        tx.success();
    }
    System.out.println("generated rel-count = " + count+" time "+(System.currentTimeMillis()-now)+" ms");

    now = System.currentTimeMillis();
    String uuidString = "flw-"+ now;
    count=0;
    try (Transaction tx = db.beginTx()) {
        for (Relationship r : GlobalGraphOperations.at(db).getAllRelationships()) {
            if (r.hasProperty("weight"))
                r.setProperty(uuidString, r.getProperty("weight"));
            count++;
        }
        tx.success();
    }
    System.out.println("global graph ops rel-count = " + count+" time "+(System.currentTimeMillis()-now)+" ms");

    final AtomicInteger pathLenght=new AtomicInteger();
    final AtomicInteger pathCount=new AtomicInteger();
    TraversalDescription tempTraversal  = db.traversalDescription()
            .depthFirst()
            .uniqueness(new UniquenessFactory() {
                            @Override
                            public UniquenessFilter create(Object optionalParameter) {
                                return new UniquenessFilter() {
                                    Set<Relationship> rels = new HashSet<Relationship>(100000);
                                    @Override
                                    public boolean checkFirst(TraversalBranch branch) {
                                        pathCount.incrementAndGet();
                                        pathLenght.set(Math.max(pathLenght.get(),branch.length()));
                                        return rels.add(branch.lastRelationship());
                                    }

                                    @Override
                                    public boolean check(TraversalBranch branch) {
                                        pathCount.incrementAndGet();
                                        pathLenght.set(Math.max(pathLenght.get(),branch.length()));
                                        return rels.add(branch.lastRelationship());
                                    }
                                };
                            }
                        }
     );
    now = System.currentTimeMillis();
    Transaction tx = db.beginTx();
    count=0;
    try {
        for(Relationship r : tempTraversal.traverse(nodes.get(0))
                .relationships()){
            if (r.hasProperty("weight"))
                r.setProperty(uuidString,r.getProperty("weight"));
            count++;
        }
        tx.success();
    } catch (Exception e) {
        System.err.println("assingTempProperty: " + e);
        tx.failure();
    } finally {
        tx.close();
    }
    System.out.println("rel-count = " + count+" time "+(System.currentTimeMillis()-now)+" ms pathlength "+pathLenght.get()+" pathCount "+pathCount.get());
}