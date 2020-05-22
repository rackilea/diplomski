@Path("json")
public class JsonResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(Model model) {
        return Response.ok(model).build();
    }

    public static class Model {

        public String name;
        private Map<String, Object> otherProps = new HashMap<>();

        @JsonAnySetter
        public void anyProps(String key, Object value) {
            otherProps.put(key, value);
        }

        @JsonAnyGetter
        public Map<String, Object> otherProps() {
            return otherProps;
        }
    }
}