private void businessMethod1(String key) {
    // do your stuff
}

private void businessMethod2(String key, String id) {
    // do your stuff
}

@GET
@Produces("application/json")
@Path("/")
public String getCardapios(@QueryParam("key") String key, 
                           @QueryParam("id") String id   ) {
    if(id == null) {
        businessMethod1(key);
    } else {
        businessMethod2(key, id);
    }
}