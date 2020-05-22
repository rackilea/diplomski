public class MyEndpointsUnix {
    @GET
    @Path("/dateAsUnix")
    public String getDateAsUnix() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.addMixIn(Foo.class, UtcFooMixIn.class);

        return mapper.writeValueAsString(new Foo());
    }
}