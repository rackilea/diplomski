@Produces(MediaType.APPLICATION_JSON)
public class UtenteResource
{

private String username;
private String profiloPath;
private String amiciPath;

/*
 * Constructor allowing it to be used as sub-resource
 */
public UtenteResource (String username)
{
    this.username = username;
    this.profiloPath = URIs.UTENTE_RES + "/" + username + URIs.PROFILO_SUBRES;
    this.amiciPath = URIs.UTENTE_RES + "/" + username + URIs.AMICI_SUBRES;
}

/*
 * Provide @GET, @PUT, @POST, @DELETE to get specific utente
 * Notice that path params are not redefined...
 */
@GET
public Utente getUtente() {
    return new Utente(username, profilioPath, amiciPath);
}    

/*
 * Define sub-resource for profilio
 */
@Path("profilio")
public ProfiloResource getProfiloResource()
{
    return new ProfilioResource(username);
}

/*
 * Define sub-resource for amici
 */
@Path("amici")
public AmiciResource getAmiciResource()
{
    return new AmiciResource(username);
}

/*
 *  These getters/setters will have nothing to do with the REST exposure
 */
public String getProfiloPath() { return profiloPath; }
public String getAmiciPath() { return amiciPath; }
public String getUsername() { return username; }
public void setUsername(String username) { this.username = username; }

}