public class CleanupSession implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        new File(somePath).delete();
    }

    // ...
}