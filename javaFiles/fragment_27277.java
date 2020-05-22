@Provider
@Produces("text/csv")
public class CSVMessageBodyWriter implements MessageBodyWriter<List<Consumer>>
{
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) 
    {
        ParameterizedType paramType = (ParameterizedType) genericType;

        if(paramType.getRawType().equals(List.class))
        {
            if(paramType.getActualTypeArguments()[0].equals(Consumer.class))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public long getSize(List<Consumer> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) 
    {
        return 0;
    }

    @Override
    public void writeTo(List<Consumer> t, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException,
            WebApplicationException 
    {
        //Write your CSV to entityStream here.
    }
}