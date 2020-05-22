Transaction transaction = graphDb.beginTx();
try {
  ReadableIndex<Node> autoNodeIndex = graphDb.index().getNodeAutoIndexer().getAutoIndex();
  Node n = autoNodeIndex.get("name", "Neo").getSingle();
  Node a = autoNodeIndex.get("name", "The Architect").getSingle();
  tx.acquireWriteLock(n);
  tx.acquireWriteLock(a);
  Boolean created = false;
  for(Relationship r : n.getRelationships(MyRels.SPEAKS_WITH) {
    if(r.getOtherNode(n).equals(a)) { // put other conditions here, if needed
      created = true;
      break;
    }
  }
  if(!created) {
    n.createRelationshipTo(a, MyRels.SPEAKS_WITH);
  }
  tx.success();
} finally {
  tx.finish();
}