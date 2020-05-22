import javax.ws.rs.GET;
    import javax.ws.rs.Path;
    import javax.ws.rs.Produces;
    import javax.ws.rs.core.MediaType;

    @Path("/hi")
    public class Entrypoint {
        @GET
        @Path("/test")
        @Produces(MediaType.TEXT_PLAIN)
        public String test() {
            return "it works";
        }

        @GET
        @Path("/")
        @Produces(MediaType.TEXT_HTML)
        public String test2() {
            return "it works";
        }

    }