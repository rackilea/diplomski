DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
dbf.setValidating(false);
DocumentBuilder db = dbf.newDocumentBuilder();
db.setEntityResolver(new EntityResolver() {
  @Override
  public InputSource resolveEntity(String arg0, String arg1)
        throws SAXException, IOException {
    if(arg0.contains("Hibernate")) {
        return new InputSource(new StringReader(""));
    } else {
        // TODO Auto-generated method stub
        return null;
    }
  }
});
Document doc = db.parse(hbmFile);