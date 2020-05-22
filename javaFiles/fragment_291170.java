ITDConnection QCConnection = ClassFactory.createTDConnection();
QCConnection.initConnection("http://nceqcwebp1/qcbin", "E_TRAVEL", "");
QCConnection.connectProject("ETVNRE", "vigupta", "Amadeus!!");
ITestSetTreeManager treeManager = QCConnection.testSetTreeManager().queryInterface(ITestSetTreeManager.class);
ITestSetFolder baseFolder = treeManager.root().queryInterface(ITestSetFolder.class);
baseFolder.addNode("Automatic Test Creation");
ITestSetFolder testSetFolder = treeManager.nodeById(baseFolder.findChildNode("Automatic Test Creation").nodeID()).queryInterface(ITestSetFolder.class);

ITestSetFactory factory = testSetFolder.testSetFactory().queryInterface(ITestSetFactory.class);
ITestSet testSet = factory.addItem(new Variant(Variant.Type.VT_NULL)).queryInterface(ITestSet.class);
testSet.name("Automatic Test Set");
testSet.status("Open");

testSet.field("CY_USER_04", "no schema used");
testSet.field("CY_USER_07", "Non-regression");
testSet.post();
testSet.unLockObject();