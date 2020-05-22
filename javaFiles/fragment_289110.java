@Path("base_endpoint")
   public class ComplaintSupportResource{

    **@POST**
    @Path("/endPoint")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response complaintRegister(ComplaintDTO caliamtDTO) {
        ComplaintResponseDTO response =complaintService.registerComplaint(caliamtDTO);
        return Response.ok(response).build();
    }
}