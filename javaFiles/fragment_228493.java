Property rdfTypeProp = model.getProperty(
  "http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
Resource categoryNode = model.getResource(
  "https://jazz.net/xmlns/prod/jazz/rtc/cm/1.0/Category");
StmtIterator categoryIterator = model.listStatements(
  new SimpleSelector(null, rdfTypeProp , categoryNode));