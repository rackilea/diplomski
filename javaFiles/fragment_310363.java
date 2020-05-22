public static void main(String[] args) throws Exception {
    OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
    // load the importing ontology
    OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new StringDocumentSource(test_owl));
    OWLReasoner r = new FaCTPlusPlusReasonerFactory().createReasoner(ontology);
    OWLClass person = ontology.getOWLOntologyManager().getOWLDataFactory().getOWLClass(IRI.create("http://localhost/CA/SmartHome/SmartHome_1113#Person"));
    Set<OWLClass> classes = r.getSubClasses(person, false).getFlattened();
    System.out.println(classes);
}