@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/getAll")
public HotelServices getResources() throws IOException {
    HotelServices services = new HotelServices(); // assuming you would assign value to this 
    return services;
}}