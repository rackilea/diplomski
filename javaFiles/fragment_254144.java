@Path("/product")
public class ProductRestService {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        Connection con = ...; //retrieve your database connection
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name FROM product");
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            productList.add(product);
        }
        //ALWAYS close the resources
        rs.close();
        stmt.close();
        conn.close();
        return productList;
    }
}