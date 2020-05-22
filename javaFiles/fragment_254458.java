@Path("/getArticlebyCat/{categoryID}")
@PermitAll
@GET
@Produces("application/json")
public Response searchArticleByCategoryID(@PathParam("categoryID")String categoryID) {

}