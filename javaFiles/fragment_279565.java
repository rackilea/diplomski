@Path("SomePATH")
public class SampleWS{
   ...

   @POST
   @Path("{layer}/Edit")
   @Produces("application/json")
   @RolesAllowed({"RoleEdit"})
   public String edit(@PathParam("layer")String layer){
       //some code
   }
}