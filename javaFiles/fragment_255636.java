@ServerEndpoint(value = "/rooms/{roomnumber}")
public class....

static Map<String, Session> openSessions = ...
@OnOpen
public void onConnectionOpen(final Session session, @PathParam("roomnumber") final String roomnumber, 
...
   //store roomnumber in session
   session.getUserProperties().put("roomnumber", roomnumber);
   openSessions.put( String.valueOf(session.getId()), session )