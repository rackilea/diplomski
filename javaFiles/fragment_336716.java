@Produces ( "application/json" )
@Consumes ( "application/json" )
@Provider
public class XstreamJsonProvider implements MessageBodyReader<Object>,
    MessageBodyWriter<Object> {

@Override
public boolean isWriteable ( Class<?> type, Type genericType, 
    Annotation[] annotations, MediaType mediaType ) {
    return MediaType.APPLICATION_JSON_TYPE.equals ( mediaType ) 
        && type.equals ( Demo.class );
}

@Override
public long getSize ( Object t, Class<?> type, Type genericType, 
    Annotation[] annotations, MediaType mediaType ) {
    // I'm being lazy - should compute the actual size
    return -1;
}

@Override
public void writeTo ( Object t, Class<?> type, Type genericType, 
    Annotation[] annotations, MediaType mediaType, 
    MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream ) 
    throws IOException, WebApplicationException {
    // deal with thread safe use of xstream, etc.
    XStream xstream = new XStream ( new JettisonMappedXmlDriver () );
    xstream.setMode ( XStream.NO_REFERENCES );
    // add safer encoding, error handling, etc.
    xstream.toXML ( t, entityStream );
}

@Override
public boolean isReadable ( Class<?> type, Type genericType, 
    Annotation[] annotations, MediaType mediaType ) {
    return MediaType.APPLICATION_JSON_TYPE.equals ( mediaType ) 
        && type.equals ( Demo.class );
}

@Override
public Object readFrom ( Class<Object> type, Type genericType, 
    Annotation[] annotations, MediaType mediaType, 
    MultivaluedMap<String, String> httpHeaders, InputStream entityStream ) 
    throws IOException, WebApplicationException {
    // add error handling, etc.
    XStream xstream = new XStream ( new JettisonMappedXmlDriver () );
    return xstream.fromXML ( entityStream );
}
}

//now your client just needs this
List providers = new ArrayList ();
XstreamJsonProvider jsonProvider = new XstreamJsonProvider ();
providers.add ( jsonProvider );
TestApi proxy = JAXRSClientFactory.create ( url, TestApi.class, 
    providers, true );

Demo d = proxy.getDemo ();
if ( d != null ) {
    System.out.println ( d.id + ":" + d.name );
}