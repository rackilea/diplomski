XStream xs = new XStream();
xs.processAnnotations(Person.class);
Person p = (Person)xs.fromXML(
  "<person>\n" +
  "  <firstname>Joe</firstname>\n" +
  "  <lastname>Walnes</lastname>\n" +
  "  <phone value='1234-456' />\n" +
  "  <fax value='9999-999' />\n" +
  "</person>");
System.out.println(p);
// prints fn: Joe, ln: Walnes, p: 1234-456, f: 9999-999