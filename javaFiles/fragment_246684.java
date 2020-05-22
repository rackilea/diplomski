String NS = "http://example.com/example#";
Property isResponsibleFor = model.getProperty( NS + "isResponsibleFor" );

Resource station = model.getResource( NS + "station1" );

for (StmtIterator i = station.listProperties( isResponsibleFor ); i.hasNext(); ) {
  Statement s = i.next();
  Resource workorder = s.getResource();
  // now you can do something with the work-order resource
}