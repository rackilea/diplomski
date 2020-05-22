@Override
public void init(PortletConfig config) throws PortletException {
    super.init(config);
    String configLocations = config.getInitParameter("contextConfigLocation");
    ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext();
    springContext.setConfigLocation(configLocations);
    springContext.refresh();
    config.getPortletContext().setAttribute(APPLICATION_CONTEXT_ATTRIBUTE, springContext);
}