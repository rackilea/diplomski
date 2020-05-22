File file = new File("test.xml");

// If you use the useWrapping option globally
// JacksonXmlModule module = new JacksonXmlModule();
// module.setDefaultUseWrapper(false);

XmlMapper xmlMapper = new XmlMapper(module);
String xml = inputStreamToString(new FileInputStream(file));
Test test = xmlMapper.readValue(xml, Test.class);