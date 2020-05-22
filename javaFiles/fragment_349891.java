public class MyProjectContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent context) {
        //query from database and create rlist and then add to context object
        context.setAttribute("rlist", rlist);
    }

    @Override
    public void contextDestroyed(ServletContextEvent context) {

    }
}