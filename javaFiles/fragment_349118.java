@Path("/foo")
@RolesAllowed({"admin", "customer"})
public class Foo {

@GET
@Produces("text/plain")
@RolesAllows("admin")
public void adminOnly() {}

public void adminOrCustomer() {}

}