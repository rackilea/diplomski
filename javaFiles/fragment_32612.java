Repository rep = ... // your RDF repository, e.g. an in-memory store or native RDF database

 try (RepositoryConnection conn = rep.getConnection()) {

    // load all files into the database
    for (File file: // loop over input files) {
        conn.add(file, "", RDFFormat.TURTLE);
    }

    // do a sparql update to remove all instances of ex:Foo
    conn.prepareUpdate("DELETE WHERE { ?s a ex:Foo; ?p ?o }").execute();

    // export to file
    con.export(Rio.createWriter(RDFFormat.TURTLE, outFile));
 } finally {
    rep.shutDown(); 
 }