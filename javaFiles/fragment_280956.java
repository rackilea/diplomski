public static final String ROLES_NS = "http://example.com/ns/roles#";

public static void main(String[] args) {
    OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
    ontModel.setNsPrefix("roles", ROLES_NS);

    DatatypeProperty prop = ontModel.createDatatypeProperty(
            ROLES_NS + "Role-description");
    prop.setRDFType(OWL.FunctionalProperty);
    prop.addRDFType(OWL.DatatypeProperty);

    RDFDataMgr.write(System.out, ontModel, RDFFormat.RDFXML_PRETTY);
}