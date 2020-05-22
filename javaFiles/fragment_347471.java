@Path("/stock")
public class StockResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Stock stock = new Stock();
        stock.setQuantity(3);

        GenericEntity<List<Stock>> entity = 
            new GenericEntity<List<Stock>>(Lists.newArrayList(stock)) {};
        return Response.ok(entity).build();
    }
}