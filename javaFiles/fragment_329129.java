BasicConfigurator.configure();
FileManager.get().addLocatorClassLoader(QuerySparql.class.getClassLoader());
Model model = FileManager.get().loadModel("My_Path//sample.ttl", "TTL");
String queryString = 
            "PREFIX db: <http://dbpedia.org/resource> \n" +
            "SELECT ?meshId WHERE{ \n" + 
            "?autism <http://xmlns.com/foaf/0.1/name> \"Autism\"@en .\n" +
            "?autism <http://dbpedia.org/ontology/meshId> ?meshId \n" +
            "}";

Query query = QueryFactory.create(queryString);
QueryExecution qexec = QueryExecutionFactory.create(query, model);

ResultSet results = qexec.execSelect();
if(results.hasNext()) {
    System.out.println("has results!");
}
else {
    System.out.println("No Results!");
}

while(results.hasNext()) {
    QuerySolution soln = results.nextSolution();
    Literal r = soln.getLiteral("meshId");
    System.out.println(r);
}