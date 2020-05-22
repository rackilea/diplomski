@POST
@Path("/bsghandles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public BsgHandleResponse getBsgHandlesJson(@QueryParam("key") String key, 
                                           BsgHandleRequest obj) {

    ...
}