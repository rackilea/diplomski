public class HibernateUtil implements ServletContextAware {

private ServletContext servletContext;

...

public void setServletContext(ServletContext servletContext) {
    this.servletContext = servletContext;
}

private Properties getProperties() {
  return servletContext.getAttribute("settings").getLocalHibernateProperties();  
}

...

}