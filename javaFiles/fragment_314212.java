String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?><a><b></b><c></c></a>";  

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
DocumentBuilder builder;  
try {  
    builder = factory.newDocumentBuilder();  
    Document document = builder.parse(new InputSource(new StringReader(xmlString)));  
} catch (Exception e) {  
    e.printStackTrace();  
}