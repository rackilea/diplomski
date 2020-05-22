XmlDynamic example = new XmlDynamic(xmlStringOrReaderOrInputSourceEtc);

String firstInternalName = example.get("CAEXFile|InstanceHierarchy|InternalElement|@Name").asString();
// TestProduct_1

List<String> allInternalNames = example.get("CAEXFile").children()
    .filter(hasElementName("InstanceHierarchy")) // import static alexh.weak.XmlDynamic.hasElementName;
    .flatMap(Dynamic::children)
    .filter(hasElementName("InternalElement"))
    .map(internalElement -> internalElement.get("@Name").asString())
    .collect(toList());
// [TestProduct_1, TestResource_1, TestProduct_2, TestProduct_3, TestResource_2]