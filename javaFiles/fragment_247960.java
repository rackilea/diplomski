@GET
@Produces("application/json")
@Path("/id")
public String getCardapios(@QueryParam("key") String key, 
                           @QueryParam("id") String id   ) {
...
}