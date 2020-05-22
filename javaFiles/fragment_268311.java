@GET @POST @PUT @DELETE
@Path("/echostatus/{statusCode}")
@Produces(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML)
public Response echoStatus(@PathParam("statusCode") final Integer statusCode) {
    return Response.status(statusCode.intValue()).build();
}