@Singleton
 @Startup
 public class StatefullSingleton {
   private final Map<String, SessionValues> sessions = new Hashtable<String, SessionValues>();

    @Lock(LockType.READ)
    public void addValue(String sessionId, String value) {
      if (!sessions.containsKey(sessionId))
          sessions.put(sessionId, new SessionValues());
      SessionValues p = sessions.get(sessionId);
      p.addValue(value);
  }

  @Lock(LockType.READ)
  public List<String> loadValues(String sessionId) {
    if (sessions.containsKey(sessionId))
        return sessions.get(sessionId).loadValues();
    else
        return new ArrayList<String>();
  }
}