OntModel m = .... your model .... ;
FileWriter out = null;
try {
  // XML format - long and verbose
  out = new FileWriter( "mymodel.xml" );
  m.write( out, "RDF/XML-ABBREV" );

  // OR Turtle format - compact and more readable
  // use this variant if you're not sure which to use!
  out = new FileWriter( "mymodel.ttl" );
  m.write( out, "Turtle" );
}
finally {
  if (out != null) {
    try {out.close()} catch (IOException ignore) {}
  }
}