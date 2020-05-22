JAXBContext jc = JAXBContext.newInstance(Package.class);
Unmarshaller unmarshaller = jc.createUnmarshaller();

final Map<String, ByteArrayOutputStream> outs = new HashMap<String, ByteArrayOutputStream>();

jc.generateSchema(new SchemaOutputResolver(){
    @Override
    public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        outs.put(suggestedFileName, out);
        StreamResult streamResult = new StreamResult(out);
        streamResult.setSystemId(suggestedFileName);
        return streamResult;
    }});
StreamSource[] sources = new StreamSource[outs.size()];
int i = 0;
for (Map.Entry<String, ByteArrayOutputStream> entry: outs.entrySet()) {
    System.out.append(new String(entry.getValue().toByteArray()));
    sources[i++] = new StreamSource(new ByteArrayInputStream(entry.getValue().toByteArray()), entry.getKey());
}
SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
sf.setResourceResolver(new LSResourceResolver(){
    @Override
    public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI){
        ByteArrayOutputStream bout = outs.get(systemId);
        if(bout!=null){
            return new DOMInputImpl(publicId, systemId, baseURI, new ByteArrayInputStream(bout.toByteArray()), null);
        }else
            return null;
    }
});
Schema schema = sf.newSchema(sources);
unmarshaller.setSchema(schema);
unmarshaller.setEventHandler(new ValidationEventHandler(){
    @Override
    public boolean handleEvent(ValidationEvent event){
        System.out.append(event.toString());
        return true;
    }
});

Object obj = unmarshaller.unmarshal(new File("package.xml"));