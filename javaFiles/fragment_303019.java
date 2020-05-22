// open TDB dataset
String directory = "./tdb";
Dataset dataset = TDBFactory.createDataset(directory);

// assume we want the default model, or we could get a named model here
Model tdb = dataset.getDefaultModel();

// read the input file - only needs to be done once
String source = "path/to/input.nt";
FileManager.get().readModel( tdb, source, "N-TRIPLES" );

// run a query
String q = "select * where {?s ?p ?o} limit 10";
Query query = QueryFactory.create(q);
QueryExecution qexec = QueryExecutionFactory.create(query, tdb);
ResultSet results = qexec.execSelect();
... etc ...