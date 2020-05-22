try {
    String strXML ="<?xml version='1.0' encoding='UTF-8' standalone='yes'?><custDtl><name>abc</name><mobNo>9876543210</mobNo></custDtl>";
    SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
    InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
    saxParser.parse(stream, ...);
} catch (SAXException e) {
    // not valid XML String
}