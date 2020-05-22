@POST
public Response insert(Student entity) {
    Response r;
    try {
        this.getService().insert(entity); // Throw the exception here!
        r = Response.ok().entity(entity).build();
    } catch (Exception ex) {
        r = Response.status(401).entity("Got some errors due to ...!").build();
    }
    return r;
}