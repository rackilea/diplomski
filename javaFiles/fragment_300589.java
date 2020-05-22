@Singleton
@Path("servlet")
public class ServletResource {

    @Context
    HttpServletRequest request;

    @GET
    public String getType() {
        return request.getClass().getName();
    }
}