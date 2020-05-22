DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
dbfac.setNamespaceAware(true);
DocumentBuilder docBuilder;
docBuilder = dbfac.newDocumentBuilder();
DOMImplementation domImpl = docBuilder.getDOMImplementation();    
Document doc = domImpl.createDocument("http://www.url.com/bla/bla", "ElementFile ", null);
doc.setXmlVersion("1.0");
doc.setXmlStandalone(true);

Element elementFile = doc.getDocumentElement();
elementFile.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns:common","http://www.url.com/bla/bla/bla");