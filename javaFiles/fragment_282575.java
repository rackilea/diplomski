@Path("app")
public static class BodyReaderTest{

    @Context
    private MessageBodyWorkers workers;

    @POST
    @Produces("avro/binary")
    @Consumes("avro/binary")
    public String processMessage() {

        workers.getMessageBodyReader(Person.class, Person.class, new Annotation[]{}, MediaType.APPLICATION_JSON_TYPE);
    }
 }