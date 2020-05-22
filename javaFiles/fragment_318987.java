if (pStmtHistTable == null) {
    pStmtHistTable = session.prepare(insertToCassandra);
    pStmtHistTable.setConsistencyLevel(ConsistencyLevel.ONE);
}
// create a batch statement
BatchStatement batch = new BatchStatement();

for (FileLoaderVo fileLoaderVo : LoadVo) {
    // add bound statements to the batch
    batch.add(pStmtHistTable.bind(...));
}
// execute all
session.execute(batch);