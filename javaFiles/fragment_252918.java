@Path("/categories")
@Produces("application/json")
public static class CategoryResourcesApi {

    @Context
    private ResourceContext resourceContext;

    @Path("/{catId}/products")
    public ProductResourcesApi getProducts() {
        return resourceContext.getResource(ProductResourcesApi.class);
    }
}

@Path("/products")
@Produces("application/json")
public static class ProductResourcesApi {

    @Context
    private UriInfo info;

    @GET
    @Path("/{id}")
    public Response getProducts(
            @PathParam("id") String prodId,
            @PathParam("catId") String catId) {
    }
}