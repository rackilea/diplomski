GraphDatabaseService graphDb = new EmbeddedGraphDatabase("D://My Graph");
while (rs.next()){
    String rel = rs.getString("Interface_Name");
    try (Transaction tx = graphDb.beginTx()) {
         RelationshipType relType = DynamicRelationshipType.withName(rel);
         graphDb.createNode().createRelationshipTo(graphDb.createNode(), relType);
         tx.success();
    }
}