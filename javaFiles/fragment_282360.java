public class SessionProviderFilter implements Filter {
    private static ThreadLocal<Session> sessionStore = new ThreadLocal<Session>();


    public void doFilter(...) {
        Session session = ... // get the session
        sessionStore.set(session);
        chain.doFilter(...);
        sessionStore.set(null);
   }

   public static Session getCurrentSession() {
        return sessionStore.get();
   }
}