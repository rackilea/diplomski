@Path("/users/{userId}/subscriptions")
@GET
public getSubscriptions(@PathParam("userId" int userId))
{
    if(getSubject().isPermitted("subscriptions:read:"+userId)
    {
        return Response.ok(getUserSubscriptionsFromDB(userId));
    }
    else
    {
        return Response.status(Status.UNAUTHORIZED).build();
    }
}