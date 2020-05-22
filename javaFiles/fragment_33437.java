XmlSuite suite = new XmlSuite();
suite.setName("TmpSuite");

XmlTest test = new XmlTest(suite);
test.setName("TmpTest");
List<XmlClass> classes = new ArrayList<XmlClass>();
classes.add(new XmlClass(System.getProperty("TestParameter")));
test.setXmlClasses(classes) ;

List<XmlSuite> suites = new ArrayList<XmlSuite>();
suites.add(suite);
TestNG tng = new TestNG();
tng.setXmlSuites(suites);
tng.run();