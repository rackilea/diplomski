@ServerEndpoint("/myendpoint")
public class MyEndpoint {
  // EJB that fires an event when a new article appears
  @EJB
  ArticleBean articleBean;
  // a collection containing all the sessions
  private static final Set<Session> sessions = 
          Collections.synchronizedSet(new HashSet<Session>());

  @OnOpen
  public void onOpen(final Session session) {
    // add the new session to the set
    sessions.add(session);
    ...
  }

  @OnClose
  public void onClose(final Session session) {
    // remove the session from the set
    sessions.remove(session);
  }

  public void broadcastArticle(@Observes @NewArticleEvent ArticleEvent articleEvent) {
    synchronized(sessions) {
      for (Session s : sessions) {
        if (s.isOpen()) {
          try {
            // send the article summary to all the connected clients
            s.getBasicRemote().sendText("New article up:" + articleEvent.getArticle().getSummary());
          } catch (IOException ex) { ... }
        }
      }
    }
  }
}