String testCars = "<root><car><name>car1</name></car><other><something>Unknown</something></other><car><name>car2</name></car></root>";
String startElement = "car";
int volgnummer = 1;
XMLInputFactory factory = XMLInputFactory.newInstance();
try {
    XMLStreamReader streamReader = factory.createXMLStreamReader(new StringReader(testCars));
    streamReader.nextTag();
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer t = tf.newTransformer();
    t.setOutputProperty("omit-xml-declaration", "yes");
    streamReader.nextTag();
    while ( streamReader.isStartElement() ||
          ( ! streamReader.hasNext() && 
            streamReader.nextTag() == XMLStreamConstants.START_ELEMENT)) {
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        t.transform(new StAXSource(streamReader), result);
        JSONObject jsonObject = XML.toJSONObject(writer.toString());
        jsonObject.put("sequence", ++volgnummer);
        System.out.println("XmlChunkToJson: " + jsonObject.toString());
    }
} catch (Exception e) {
    e.printStackTrace();
}