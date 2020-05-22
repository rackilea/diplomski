@POST
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public AppData getAppData(AppDataRequest appDataRequest){
    return ads.getAppData(appDataRequest.getId());
}