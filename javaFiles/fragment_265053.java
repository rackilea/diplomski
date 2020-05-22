try {
  SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
  URLConnection connection = MyClass.class.getResource("resource.xml").openConnection()
  connection.setUseCaches(false);  
  try (InputStream in = connection.getInputStream()) {
    parser.parse(in, new DefaultHandler() {...});
  }
} catch (Exception ex) {
  throw new RuntimeException("Error loading resource.xml", ex);
}