DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  DocumentBuilder parser = factory.newDocumentBuilder();
  Document xmlDoc = parser.parse(file);//file has the xml
  String xml = nodeToString(xmlDoc.getDocumentElement());//pass in the root
  //xml has the xml info. E.g no xml declaration. Add it
  xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> + xml;//bad to append this way...
  System.out.println("XML is:"+xml);