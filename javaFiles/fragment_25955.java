@Path("/{id}/api")
public class TenantsController {

   //register all your controllers including path here

    @Path("/somethings")
    public Class<SomethingController> something() {
        return SomethingController.class;
    }
}