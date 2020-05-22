RepositoryConnection conn = rep.getConnection();
try {
   // prepare the query
   String queryString = "SELECT * WHERE {?s ?p ?o . }";
   TupleQuery query = conn.prepareTupleQuery(QueryLanguage.SPARQL, queryString);

   // open a file to write the result to it in JSON format
   OutputStream out = new FileOutputStream("/path/to/output.json");
   TupleQueryResultHandler writer = new SPARQLResultJSONWriter(out);

   // execute the query and write the result directly to file
   query.evaluate(writer);  
}
finally {
   conn.close();
}