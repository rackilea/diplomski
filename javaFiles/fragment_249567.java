@Path("/")
@PermitAll
public class Resource {
@RolesAllowed("user")
@GET
public String get() { return "GET"; }

@RolesAllowed("admin")
@POST
public String post(String content) { return content; }