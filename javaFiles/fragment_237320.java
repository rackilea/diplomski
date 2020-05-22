@Path("/date")
public class DateResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postPerson(Person person) {
        return Response.ok(DateTimeFormatter.ISO_DATE.format(
                           person.getBirthDate())).build();
    }
}

@Test
public void testResteasy() throws Exception {
    WebTarget target = client.target(
            TestPortProvider.generateURL(BASE_URI)).path("date");
    String person = "{\"birthDate\":\"2015-01-04\"}";
    Response response = target.request().post(Entity.json(person));
    System.out.println(response.readEntity(String.class));
    response.close();
}