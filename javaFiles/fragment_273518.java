String resourceURI = "http://dbpedia.org/resource/Roger_Federer";
String queryString = 
            "SELECT ?property ?object " +
            "WHERE {" +
            "      <"+resourceURI+"> ?property ?object ." + 
            "}";
Query query = QueryFactory.create(queryString);
//System.out.println(queryIn);
QueryExecution qe = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
ResultSet results = qe.execSelect(); 
ResultSetFormatter.out(System.out, results, query);
qe.close();