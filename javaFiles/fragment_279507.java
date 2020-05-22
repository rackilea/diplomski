@Override
public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.register(ConfigMVC.class);
    ctx.setServletContext(servletContext);
    Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
    servlet.addMapping("/");
    servlet.setLoadOnStartup(1);
    servlet.setInitParameter("throwExceptionIfNoHandlerFound", "true");
}