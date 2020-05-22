class TestClass {
    public static void main(String[] args) {
        final ServletContext servletContext = new ServletContext();
        final ServletContextEvent servletContextEvent = new ServletContextEvent(servletContext);
        final ServletContextListener servletContextListener = new ServletContextListener();
        servletContextListener.contextInitialized(servletContextEvent);
        final Object resourceMap = servletContext.getMap().get("resourceMap");
        // See, resourceMap is still accesiable. Because it still has an alive reference to it from ServletContext!
        System.out.println(resourceMap);
        // Output will be:
        // {1=abc1}
    }
}

class ServletContext {

    final Map<String, Object> map = new HashMap<String, Object>();

    public void setAttribute(String resourceMap, Map<String, String> value) {
        this.map.put(resourceMap, value);
    }

    public Map<String, Object> getMap() {
        return map;
    }
}

class ServletContextEvent {
    private final ServletContext servletContext;

    public ServletContextEvent(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
}

class ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        Map<String, String> resourceMap = new HashMap<String, String>();
        resourceMap.put("1", "abc1");
        sce.getServletContext().setAttribute("resourceMap", resourceMap);
    }
}