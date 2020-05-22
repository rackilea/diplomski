public class MyApplicationContextListener implements ServletContextListener {

    private static final String FOO = "foo";

    public void contextInitialized(ServletContextEvent event) {
        MyObject myObject = new MyObject();
        event.getServletContext().setAttribute(FOO, myObject);
    }

    public void contextDestroyed(ServletContextEvent event) {
        MyObject myObject = (MyObject) event.getServletContext().getAttribute(
                FOO);
        try {
            event.getServletContext().removeAttribute(FOO);
        } finally {
            myObject.dispose();
        }
    }

}