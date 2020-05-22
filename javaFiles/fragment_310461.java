@POST @Consumes("application/json")
@Path("/create")
public void create(final MyJaxBean input) {
    System.out.println("param1 = " + input.param1);
    System.out.println("param2 = " + input.param2);
}