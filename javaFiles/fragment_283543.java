@POST
@Path("/savePerson")
@Consumes("application/json")
@Produces("application/json")
@Secured({ "ROLE_USER" })
public PersonBean savePerson(SavePersonBean savePersonBean) {
    PersonBean person = personDao.savePerson(savePersonBean.getFirstName(),
            savePersonBean.getLastName());
    return person;
}