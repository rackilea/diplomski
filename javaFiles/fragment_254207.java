@Test
public void classAttributeSetInResult() {
    MyInterface objectToSerialize = new MyImplementation("value1", "value2");

    final XStream xStream = new XStream(new DomDriver());
    xStream.alias("myInterfaceElement", MyImplementation.class);
    xStream.registerConverter(new MyInterfaceConverter(xStream.getMapper(), xStream.getReflectionProvider()));

    String xmlResult = xStream.toXML(objectToSerialize).toString();

    String expectedResult = 
        "<myInterfaceElement class=\"myPackage.MyImplementation\">\n" +
        "  <field1>value1</field1>\n" +
        "  <field2>value2</field2>\n" +
        "</myInterfaceElement>";

    assertEquals(expectedResult, xmlResult);
}