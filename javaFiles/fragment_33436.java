// open a connection to the Sesame repository containing your statements
 RepositoryConnection conn = repository.getConnection();
 try {
     // create a prepared query object from your query string
     TupleQuery query = conn.prepareTupleQuery(QueryLanguage.SPARQL, queryString);

     // evaluate the query on the repository
     TupleQueryResult result = query.evaluate(); 

     // iterate over the results and do something with each result
     while (result.hasNext()) {
          BindingSet s = result.next();
          Value subject = s.getValue("subject");
          Value object = s.getValue("object");

          System.out.println("value of ?subject: " + subject);
          System.out.println("value of ?object: " + object);
     }
 } finally {
       conn.close();
 }