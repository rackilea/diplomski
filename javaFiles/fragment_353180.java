@POST
@Path("/{contestType}/pay")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public Response pay(@PathParam("contestType") String contestType,
                    @FormParam("contestId") Long contestId, 
                    @FormParam("username") String username,
                    @FormParam("amount") Long amount) {
    ...
}