@Consumes("application/json")
@Provider
public class PersonReader 
 implements MessageBodyReader<Person> {
    ObjectMapper mapper;

    public PersonReader(){
        mapper = new ObjectMapper();
    }

    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == Person.class;
    }

    public Person readFrom(Class<Person> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        Person p = mapper.readValue(entityStream, Person.class);
        return p;
    }
}