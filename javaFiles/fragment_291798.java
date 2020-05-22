@Path("controller")
@Stateless
public class ControllerEJB {


    @POST
    public void registerUser(
           @QueryParam("fornamn") String fornamn,
           @QueryParam("efternamn") String efternamn,
           @QueryParam("epost") String epost,
           @QueryParam("epost2") String epost2,
           @QueryParam("password") String password,
           @Context HttpServletRequest request){

           HttpSession session = request.getSession(true);

           ...

    }
}