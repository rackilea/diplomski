@GET
@Path("/name")
@Produces(MediaType.TEXT_PLAIN)
public String getName() {
    return name;
}
@GET
@Path("/password")
@Produces(MediaType.TEXT_PLAIN)
public String getPassword() {
    return password;
}