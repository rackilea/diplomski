public class AvroMessageReader implements MessageBodyReader<Person> {

    AvroSchema schema;

    final AvroMapper avroMapper = new AvroMapper();

    public AvroMessageReader(){
        schema = avroMapper.schemaFor(Person.class); //generates an Avro schema from the POJO class.
    }

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return type == Person.class; //determines that this reader can handle the Person class.
    }

    @Override
    public Person readFrom(Class<Person> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException {
        return avroMapper.reader(schema).readValue(in);
    }

}