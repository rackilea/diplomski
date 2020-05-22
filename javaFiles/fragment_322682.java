@Path("/helloworld")
@RolesAllowed({"ADMIN", "ORG1"})
public class helloWorld {

@GET
@Path("sayHello")  
@Produces("text/plain")
@RolesAllowed("ADMIN")
public String sayHello() {
   return "Hello World!";
}
}