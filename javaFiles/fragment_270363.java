@ServerEndpoint(value = "/chat/{room}", configurator = GetHttpSessionConfigurator.class, encoders = ChatMessageEncoder.class, decoders = ChatMessageDecoder.class) 
public class ChatEndpoint {

private final Logger log = Logger.getLogger(getClass().getName());

@OnOpen
public void open(final Session session,
        @PathParam("room") final String room, EndpointConfig config) {

    log.info("session openend and bound to room: " + room);

    Principal userPrincipal = (Principal) config.getUserProperties().get(
            "UserPrincipal");
    String user=null;
    try {
         user = (String) userPrincipal.getName();
    } catch (Exception e) {
        e.printStackTrace();
    }
    session.getUserProperties().put("user", user);
    System.out.println("!!!!!!!! "+user);

}}