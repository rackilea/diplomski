@Path("/cart")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ShoppingCart {

    @Inject
    private ShoppingCartService service;

    @GET
    public Response getProducts() {
        ...
    }

    @POST
    public Response addProduct(Product product) {
        ...
    }
}