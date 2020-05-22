JAXBContext jc = JAXBContext.newInstance(Something.class);
final List<ByteArrayOutputStream> outs = new ArrayList<ByteArrayOutputStream>();
jc.generateSchema(new SchemaOutputResolver(){
    @Override
    public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        outs.add(out);
        StreamResult streamResult = new StreamResult(out);
        streamResult.setSystemId("");
        return streamResult;
    }});
StreamSource[] sources = new StreamSource[outs.size()];
for (int i=0; i<outs.size(); i++) {
    ByteArrayOutputStream out = outs.get(i);
    // to examine schema: System.out.append(new String(out.toByteArray()));
    sources[i] = new StreamSource(new ByteArrayInputStream(out.toByteArray()),"");
}
SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
m.setSchema(sf.newSchema(sources));
m.marshal(docs, new DefaultHandler());  // performs the schema validation