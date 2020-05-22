@Path("/example")
public interface Service {
    @GET
    @Path("/products/{pIds}")
    @Produces( "application/json" )
    public ServiceResponse<ProductsList> getProducts(
        @PathParam("pIds") List<String> productsIds,
        @QueryParam("expand") String expand,
        @QueryParam("storeIds") String storeIds) throws Exception;
}