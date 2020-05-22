@GET
@Path("/person/{name}")
@Produces("application/xml")
public Person getPerson(@PathParam("name") String name) {
    Person personOrNull = people.byName(name);
    if(personOrNull == null) {
      throw new WebApplicationException(404);
    }   
    return personOrNull;
}