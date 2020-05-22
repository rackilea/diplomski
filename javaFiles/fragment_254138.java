JAXBContext jc = JAXBContext.newInstance( "generated" );
Unmarshaller u = jc.createUnmarshaller();
Person contents = (Person) u.unmarshal(Testit.class.getResource("./anysample_test1.xml"));
System.out.println("contents: " + contents);
System.out.println("  firstname: " + contents.getFirstname());
System.out.println("  lastname: " + contents.getLastname());
System.out.println("  any: ");
for (Object anyItem : contents.getAny()) {
    System.out.println("    any item: " + anyItem);
    Element ele = (Element) anyItem;
    System.out.println("      ele name: " + ele.getTagName());
    System.out.println("      ele text content: " + ele.getTextContent());
}