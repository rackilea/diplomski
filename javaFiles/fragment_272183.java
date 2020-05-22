@GET
@Path("/list")
public Collection<Person> list() {
    System.out.println("In Person::list" );
    return personMgr.getPersons();
}