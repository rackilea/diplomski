@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path("getCloseness_vertices")
public String getCloseness_vertices(MyPojo p) 
{
    int i = p.algID;
}