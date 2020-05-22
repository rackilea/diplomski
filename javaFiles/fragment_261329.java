public class MyBean implements Serializable {
    private String title;
    private List<JaxData> names;
    private String city;
    private String country;

    // Constructors, getters/setters
}

@POST
@Path(value="json")
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.APPLICATION_JSON)
public String jsonTest(final MyBean data) {
    return data.toString();
}