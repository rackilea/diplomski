public class Bean {
    @PathParam("id")
    private String id;
    @XxxParam("..")
    private String param;
    // getters and setters
}

@POST
public Response(@BeanParam Bean bean, JsonBody entity) {}