class Result{
    public List<Pair<Long,Long>> getList();
    ...
}

@Path("/coordinates")
public class CoordinatesResource {

    @GET
    @Produces
    public Result getCoordinates(String location){
        return ...;
    }
}