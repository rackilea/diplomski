@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {

        client = ClientBuilder.newClient();
        target = client.target("http://api.anotherRestService.com/details/")

        return target.request(MediaType.APPLICATION_JSON)
            .get();
    }
}