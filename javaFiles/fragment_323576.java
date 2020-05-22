@Path("")
public class JerseyResource{

    boolean isSandbox = false;

    public JerseyResource(@Context HttpServletRequest req) {
        if(req.getRequestURI().startsWith("/nexus/sandbox"))
            isSandbox = true;
    }