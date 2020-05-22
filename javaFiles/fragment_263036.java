@Override
public void init(ServletConfig config) throws ServletException {
    super.init(config);
    WebApplicationContext ctx = WebApplicationContextUtils
            .getRequiredWebApplicationContext(config.getServletContext());
    AutowireCapableBeanFactory beanFactory = ctx
            .getAutowireCapableBeanFactory();
    beanFactory.autowireBean(this);
}