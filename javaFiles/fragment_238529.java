@Produces(MediaType.APPLICATION_JSON)
public class AmiciResource {

private String username;

/*
 * Constructor allowing it to be used as sub-resource
 */
public AmiciResource (String username)
{
    this.username = username;
}

/*
 * Provide @GET, @PUT, @POST, @DELETE to get specific amici
 * Notice that path params are not redefined...
 */
@GET
public Amici getAmici() {
    // however you build the amici object here
    return new Amici(username);
}    

}

@Produces(MediaType.APPLICATION_JSON)
public class ProfilioResource {

private String username;

/*
 * Constructor allowing it to be used as sub-resource
 */
public ProfilioResource (String username)
{
    this.username = username;
}

/*
 * Provide @GET, @PUT, @POST, @DELETE to get specific profilio
 * Notice that path params are not redefined...
 */
@GET
public Profilio getProfilio() {
    // however you build the profilio object here
    return new Profilio(username);
}    

}