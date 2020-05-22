@GET
@Produces(MediaType.TEXT_PLAIN)
public String getName() {
    return name;
}
@GET
@Produces(MediaType.TEXT_PLAIN)
public String getPassword() {
    return password;
}