@POST
@Path("/upload")
@Consumes("application/xml")
public void upload(Product product) {
  assert product.price().equals("50 USD");
}