FileManager fManager = FileManager.get();
Model model = fManager.loadModel("some_file.rdf");

Property someRelevantProperty = 
    model. createProperty("http://your.data.org/ontology/",
                          "someRelevantProperty");

SimpleSelector selector = new SimpleSelector(null, null, (RDFNode)null) {
    public boolean selects(Statement s)
        { return s.getPredicate().equals(someRelevantProperty);}
}

StmtIterator iter = model.listStatements(selector);
while(it.hasNext()) {
   Statement stmt = iter.nextStatement();
   System.out.print(stmt.getSubject().toString());
   System.out.print(stmt.getPredicate().toString());
   System.out.println(stmt.getObject().toString());
}