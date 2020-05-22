@GET
@Consumes(MediaType.APPLICATION_XML) //client sends also xml
@Produces(MediaType.APPLICATION_XML)
@Path("{hotelId}")
public HotelRESTInfo read(@PathParam("hotelId") long hotelId) {
    (...)
}