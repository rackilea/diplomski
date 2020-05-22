DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
String strXMLAlert = "<a>永</a>";
InputStream is = new ByteArrayInputStream(strXMLAlert.getBytes("UTF-8"));
Document document = db.parse(is);
Node item = document.getDocumentElement().getChildNodes().item(0);
String nodeValue = item.getNodeValue();
System.out.println(nodeValue);