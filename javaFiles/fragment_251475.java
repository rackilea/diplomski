public class MySessionListener implements BayeuxServer.SessionListener {
  @Override
  public void sessionAdded(ServerSession session, ServerMessage message) {
    Map<String, Object> ext = message.getExt();
    if (ext != null) {
      Map<String, Object> extra = (Map<String, Object>)ext.get("com.acme");
      if (extra != null) {
        String token = (String)extra.get("token");
        session.setAttribute("token", token);
      }
    }
  }

  @Override
  public void sessionRemoved(ServerSession session, boolean timedout) {
  }
}