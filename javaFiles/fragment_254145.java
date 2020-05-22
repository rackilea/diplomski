public class ProductDao {
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        Connection con = ...; //retrieve your database connection
        //the rest of the code explained above...
        return productList;
    }
}

@Path("/product")
public class ProductRestService {
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        ProductDao productDao = new ProductDao();
        return productDao.getProducts();
    }
}