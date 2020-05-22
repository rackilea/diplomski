DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
dbf.setValidating(false);
DocumentBuilder db = dbf.newDocumentBuilder();
Document d = db.parse(...);
DOMSource ds = new DOMSource(d);