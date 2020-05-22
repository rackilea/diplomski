OntModel m = ... your model ... ;
NS = "http://your.domain/example#";

// define the various classes

OntClass layer = m.createClass( NS + "Layer" );
layer.setLabel( "layer", "en" );

OntClass networkLayer = m.createClass( NS + "NetworkLayer" );
layer.setLabel( "network layer", "en" );
// ...

// create the class hierarchy

layer.addSubClass( networkLayer );
// ...

// save the file
FileWriter out = null;
try {
    out = new FileWriter( "./test.owl" );
    m.write( out, "RDF/XML-ABBREV" );
}
finally {
    if (out != null) {
        try {out.close()) ) catch (IOException ignore) {}
    }
}