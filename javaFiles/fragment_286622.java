ObjectMapper xmlMapper = new XmlMapper();
xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
File file = new File("/path/fileName.xml");

String sHead = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n";
String sResult = xmlMapper.writeValueAsString(geObjectToSerialize());
String xml = sHead + sResult;

FileUtils.write(file, xml, "ISO-8859-1");