@POST
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Path("/{EmployeeID}/Shifts/{ShiftID}/Confirm")
public Response confirmShift(@PathParam("EmployeeID") String employeeId,
                             String params,
                             @PathParam("ShiftID") String tbId,
                             @Context MessageContext context){
    HttpServletRequest request = context.getHttpServletRequest();
    String ip = request.getRemoteAddr();

    /** ..... **/
}