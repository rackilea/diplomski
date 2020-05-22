@Path("users")
public class UtenteCollectionResource
{

/*
 * Path annotation with param username defined here when using sub-resources,
 * not in the top-level resource
 */
@Path({username})
public UtenteResource doGet (@PathParam("username") String username)
{
    return new UtenteResource (username);
}

/*
 * Provide @GET, @PUT, @POST, @DELETE to get collection of containers
 *
 * Please note that the following is not best-practice -- you should POST to the
 * collection when creating a new element, not POST to specific element.  The
 * following may work for you, but please revisit after you get sub-resources
 * working.  The username should NOT be coming in on the path in this case.
 */
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path({username})
public Response doPost (@PathParam("username") String username , AuthDTO auth)
{
    new UtenteService ().registrazione(username, auth.getPassword(), auth.getEmail());
    return Response.ok().build();
}

}