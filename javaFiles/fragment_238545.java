try {
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbFactory.newDocumentBuilder();
    db.setEntityResolver(new EntityResolver() {

        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
            return null; // Never resolve any IDs
        }
    });

    System.out.println("BUILDING DOM");

    Document doc = db.parse(new FileInputStream("/home/pd/XSLT/wordpress.xml"));

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    TransformerFactory tFactory = TransformerFactory.newInstance();
    Transformer transformer = tFactory.newTransformer(
        new StreamSource("/home/pd/XSLT/transf.xslt"));

    System.out.println("RUNNING TRANSFORM");

    transformer.transform(
            new DOMSource(doc.getDocumentElement()),
            new StreamResult(outputStream));

    System.out.println("TRANSFORMED CONTENTS BELOW");
    System.out.println(outputStream.toString());
} catch (Exception e) {
    e.printStackTrace();
}