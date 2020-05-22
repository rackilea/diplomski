@POST
@Produces({"application/json"})
public Response scorePoints(User user, long score)
{
    leaderboardService.add(user, score);
    return Response.ok().build();
}