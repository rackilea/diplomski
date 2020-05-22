@GET
@Path("{ref}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.TEXT_PLAIN)
public SpecialDTO findByGuestRef(@PathParam("ref") String pRefeference) {
  // find the special and return it
 return new SpecialDTO(special);
}


public class SpecialDTO {

    //declare here only the attributes that you want in your response

    public SpecialDTO(Special sp) {
        this.attr=sp.attr; // populate the needed attributes
    }

}