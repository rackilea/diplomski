@WebListener
public class SessionConfigureListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setAttribute("foo", new Foo());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // NOOP.
    }

}