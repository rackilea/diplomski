String fileName = "your_file_name_here.rdf";
FileWriter out = new FileWriter( fileName );
try {
    model.write( out, "RDF/XML-ABBREV" );
}
finally {
   try {
       out.close();
   }
   catch (IOException closeException) {
       // ignore
   }
}