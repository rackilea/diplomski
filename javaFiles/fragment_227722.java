String q = "select * where {?s ?p \"foo\"}";
QuerySolutionMap qsm = new QuerySolutionMap();
qsm.bind( "p", DC.creator );
Query query = QueryFactory.create( q );
QueryExecution exec = QueryExecutionFactory.create( query, model, qsm );
ResultSet rs = exec.execSelect();