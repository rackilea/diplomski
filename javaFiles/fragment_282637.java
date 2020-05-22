public static void main(String ... strings) {
    OntModel m = ModelFactory.createOntologyModel();
    m.setNsPrefix("test", "http://test#");
    Individual i = m.createIndividual("http://test#indi", m.createResource("http://test#cl"));
    i.addProperty(RDFS.comment, "something");
    i.addRDFType(OWL2.NamedIndividual);
    m.write(System.out);
}