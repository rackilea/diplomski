@Component
//Don't use @Path, as path info is already defined in the TenantsController
public class SomethingController {
    //do your stuff here;

    @GET
    @Path("/{id}") //Path for this example would be /tenants/{id}/api/somethings/{id}
    public JsonApiResult get(@PathParam("id") int id) {
       //retrieve one something
    }
}