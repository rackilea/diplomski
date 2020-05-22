DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
InputSource is = new InputSource();
is.setCharacterStream(new StringReader(yourXMLString));

Document doc = db.parse(is);
NodeList nodes = doc.getElementsByTagName("first-node");