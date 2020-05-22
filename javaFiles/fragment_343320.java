@Path("/api/pusher")
public class PusherAction extends BusinessApiAction {
    @POST

    @Produces({ "application/Json", "application/xml" })
    public Response pusher(@Context ServletContext context, @Context HttpServletRequest req, @Context HttpServletResponse res, @FormParam("socket_id") String socketId, @FormParam("channel_name") String channelName) throws Exception {
        System.out.println("\n\n===channel==> " + channelName + "\t socket id-->" + socketId);

        Pusher pusher = new Pusher(APP_ID, APP_KEY, APP_SECRET);
        String userId = "5433d5da97d88628ec000300";
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("name", "Phil Leggetter");

        String authBody = pusher.authenticate(socketId, channelName, new PresenceUser(userId, userInfo));

        return sendDataResponse(authBody);
    }

}