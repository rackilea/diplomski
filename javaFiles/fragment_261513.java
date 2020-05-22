@GET
@Path("/query")
public String queryValues(@QueryParam("Country") List<String> countries,
                          @QueryParam("City") List<String> cities) {
   // Do work here
}