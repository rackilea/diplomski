@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
@Path("/YOUR_PATH")
public Service postService(@FormParam("EMP_ID") String param1)
{
    //Do your stuff
}