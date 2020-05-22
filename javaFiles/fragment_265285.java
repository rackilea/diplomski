public class Operands {
    private int x;
    private int y;
    // getX setX getY setY
}
...
@POST
@Path("/sumPost")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public String sumPost(Operands ops) {

}