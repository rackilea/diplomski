@Path("/sports")
    public interface SportsEndpoint {

        @GET
        List<Player> getPlayers(@QueryParam("sportId") String sportId, @QueryParam("sportName") String sportName , @QueryParam("country") String country){
if(sportId ! =null && sportName!=null)
{
getPlayersOfSports(sportId,sportName);
}
else if (sportId ! =null && sportName!=null && country!=null)
{
getPlayersOfSports(sportId,sportName,country);
}
}