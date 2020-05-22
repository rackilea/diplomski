@Test
public final void test() {
    // Create a doc manager / modelspec to resolve imports
    final OntDocumentManager docManager = new OntDocumentManager();
    final OntModelSpec modelSpec = new OntModelSpec(OntModelSpec.OWL_DL_MEM);
    modelSpec.setDocumentManager(docManager);

    // Create an imported model that can be referenced by the docManager
    final OntModel imprt = ModelFactory.createOntologyModel(modelSpec);
    docManager.addModel("x-model://a", imprt);

    // Populate imported model with some content
    final Ontology imprtOnt = imprt.createOntology("x-model://a");
    final OntClass clazz = imprt.createClass("x-model://a/class");
    assertTrue("delcared class should exist in a", imprt.contains(clazz, RDF.type, OWL.Class));

    System.out.println("x-model://a before");
    System.out.println("-------------------------------------------");
    imprt.write(System.out, "N3");
    System.out.println("\n");

    // Create a model which imports x-model://a
    final OntModel model = ModelFactory.createOntologyModel(modelSpec);
    model.setDynamicImports(true);
    final Ontology modelOnt = model.createOntology("x-model://b");
    modelOnt.addImport(imprtOnt);

    assertTrue("import b->a does not exist", model.hasLoadedImport("x-model://a"));
    assertTrue("triples in a should be acessible through b", model.contains(clazz, RDF.type, OWL.Class));
    assertFalse("triples in a should not be acessible through b's baseModel", model.getBaseModel().contains(clazz, RDF.type, OWL.Class));

    // Populate this new model
    final Individual ind = model.createIndividual("x-model://b/individual", clazz);
    assertTrue("delcared individual should exist in b", model.contains(ind, RDF.type, clazz));

    System.out.println("x-model://a after");
    System.out.println("-------------------------------------------");
    imprt.write(System.out, "N3");
    System.out.println("\n");

    System.out.println("x-model://b");
    System.out.println("-------------------------------------------");
    model.write(System.out, "N3");
}