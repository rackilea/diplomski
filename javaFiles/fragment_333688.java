public class SimpleServlet extends JerseyServletModule{

    @Override
    protected void configureServlets() {
        configureGuiceServlet();
    }

    private void configureGuiceServlet() {
        serve("/service/*").with(GuiceContainer.class, new HashMap<String, String>());
        bind(Manager.class).to(ManagerImpl.class);
    }
}