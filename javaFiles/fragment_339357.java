final org.neo4j.graphdb.Transaction tx = this.neoTemplate.getGraphDatabaseService().beginTx();
try {
    updatedUser = userRepository.save(updatedUser);
    tx.success();
} finally {
    tx.finish();
}