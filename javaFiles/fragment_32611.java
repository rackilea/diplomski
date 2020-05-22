RDFWriter writer = org.eclipse.rdf4j.rio.Rio.createWriter(RDFFormat.TURTLE, outFile);

  writer.startRDF();
  for (File file : // loop over your 100+ input files) {
      Model data = Rio.parse(new FileInputStream(file), "", RDFFormat.TURTLE);
      for (Statement st: data) {
         if (// you want to keep this statement) {
              writer.handleStatement(st);
         }
      }
  }
  writer.endRDF();