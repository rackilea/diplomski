@Path("/") 
class RootResource {
    @Context ServletContext context;

    @Path("/swagger")
    public ApiListingResource swagger() {
        return new ApiListingSubResource(context);
    }
}