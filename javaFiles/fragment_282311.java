Repository myRepository = new HTTPRepository(serverURL, repositoryId);   
myRepository.initialize(); 
RepositoryConnection con = myRepository.getConnection(); 
ValueFactory f = myRepository.getValueFactory();

i = 0; 
j = 1000000;    

try {
  con.begin(); // start the transaction
  while(i < j) {
      URI event    = f.createURI(ontologyIRI + "event"+i);
      URI hasTimeStamp    = f.createURI(ontologyIRI + "hasTimeStamp");
      Literal timestamp   = f.createLiteral(fields.get(0));
      con.add(event, hasTimeStamp, timestamp);
      i++; 
  }
  con.commit(); // finish the transaction: commit all our adds in one go.
}
finally {
  // always close the connection when you're done with it. 
  con.close();
}