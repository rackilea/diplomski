@Provider
public class MyMessageBodyReader 
  implements MessageBodyReader<A> {
     @Override
     public boolean isReadable(final Class<?> type,final Type genericType,
                               final Annotation[] annotations,
                               final MediaType mediaType) {
         // you can check if the media type is JSon also but it's enougth to check 
         // if the type is a subclass of A
         return A.class.isAssignableFrom(type);  // is a subclass of A?
     }
     @Override
     public A readFrom(final Class<A> type,
                       final Type genericType,
                       final Annotation[] annotations,
                       final MediaType mediaType,
                       final MultivaluedMap<String,String> httpHeaders,
                       final InputStream entityStream) throws IOException,
                                                              WebApplicationException {
        // create an instance of B or C using Jackson to parse the entityStream (it's a POST method)        
    }
}