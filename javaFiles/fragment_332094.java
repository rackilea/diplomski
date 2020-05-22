Model model = ...; // your model

// create and initialize a temporary in-memory store
Repository rep = new SailRepository(new MemoryStore());
rep.initialize();

try (RepositoryConnection conn = rep.getConnection()) {
   // load the model into the repository
   conn.add(model);

  // execute the query
  String query = "ASK WHERE { :s (:p1|:p2|:p3)+ :o . }";
  boolean pathExists = conn.prepareBooleanQuery(query).evaluate();
}