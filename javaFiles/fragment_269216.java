private OntModel m;

public void method1() {
    this.m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
}

public ArrayList<String> method2(String ontoClass) {
    method1();
    this.m.read("http://localhost/myont/ont.owl"); // use field value