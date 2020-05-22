Transaction tx = graphDb.beginTx();     
Node n = null;
try {
    n = graphDb.createNode();
    tx.success();
} catch (Exception e) {
    tx.failure();
} finally {
    tx.finish();
}