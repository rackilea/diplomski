@Path("person")
public class LocalDateResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson() {
        Person person = new Person();
        person.birthDate = LocalDate.now();
        return Response.ok(person).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person) {
        return Response.ok(
                DateTimeFormatter.ISO_DATE.format(person.birthDate)).build();
    }

    public static class Person {
        public LocalDate birthDate;
    }
}