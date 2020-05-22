@WebListener
public class MySessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        // new session created - add your singleton
        Foo f = new Foo();
        se.getSession().setAttribute("Foo", f);
        // if you need id you can use - se.getSession().getId();
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        // session destroyed - do cleanup
        Foo f = (Foo) se.getSession().getAttribute("Foo");
        f.destroy(); // your object cleanup method
    }
}