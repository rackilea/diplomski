@Provider
@Consumes(MediaType.APPLICATION_XML)
public class DomainMessageBodyReader implements MessageBodyReader {
    private static final String XSD_PATH = "path/to/domains.xsd";

    @Context
    private Providers providers;
    private Schema schema;

    public DomainMessageBodyReader()  {
        try {
            initSchema();
        } catch (Exception ex) {
            Logger.getLogger(DomainMessageBodyReader.class.getName())
                                         .log(Level.SEVERE, null, ex);
            throw new InternalServerErrorException();
        }
    }

    private void initSchema() throws Exception  {
        SchemaFactory factory 
                = SchemaFactory.newInstance(
                                     XMLConstants.W3C_XML_SCHEMA_NS_URI);
        schema = factory.newSchema(new File(XSD_PATH));
    }

    @Override
    public boolean isReadable(Class type, Type type1, 
            Annotation[] antns, MediaType mt) {
        return type == Domain.class || type == Domains.class;
    }

    @Override
    public Object readFrom(Class type, Type type1, Annotation[] antns, 
            MediaType mt, MultivaluedMap mm, InputStream in) 
            throws IOException, WebApplicationException {
        try {

            JAXBContext context = JAXBContext.newInstance(Domains.class, 
                                                          Domain.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);
            return unmarshaller.unmarshal(in);
        } catch (JAXBException ex) {
            throw new InternalServerErrorException();
        }
    }  
}