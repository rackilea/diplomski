@POST
@Path("/get")
public Response getEmplByPostReqParam(@FormParam("param1") String id) {
    System.out.println("getEmplByPostReqParam");
    EmployeeDAO dbHandler = new EmployeeDAOImpl();
    Employee fetchedEmployee = dbHandler.findEmployee(Integer.parseInt(id));
    ResponseBuilder rb = new ResponseBuilderImpl();
    rb.type(MediaType.APPLICATION_ATOM_XML);
    rb.entity(fetchedEmployee);
    return rb.build();
}