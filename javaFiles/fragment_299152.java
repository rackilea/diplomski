OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
    OWLOntology ontology = manager.createOntology();
    OWLDataFactory factory = manager.getOWLDataFactory();
    FunctionalSyntaxDocumentFormat pm = new FunctionalSyntaxDocumentFormat();
    pm.setPrefix(":", "http://test.owl/test#");
    manager.setOntologyFormat(ontology, pm);
    OWLClass item = factory.getOWLClass("item", pm);
    manager.addAxiom(ontology, factory.getOWLDeclarationAxiom(item));
    manager.saveOntology(ontology, System.out);