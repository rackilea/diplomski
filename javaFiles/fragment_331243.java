String queryStr = "dbpedia query ";

Dataset dataset = TDBFactory.createDataset(tdbDirectory);
Model tdb = dataset.getDefaultModel();

Query query = QueryFactory.create(queryStr);
QueryExecution qexec = QueryExecutionFactory.create(query, tdb);

/*Execute the Query*/
ResultSet results = qexec.execSelect();

while (results.hasNext()) {
    // Do something important
}

qexec.close();
tdb.close() ;