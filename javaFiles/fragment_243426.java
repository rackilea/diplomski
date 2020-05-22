@Override
public void onStartup(ServletContext servletContext) throws ServletException {
    ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
    defaultServlet.addMapping("/favicon.ico");
    super.onStartup(this.servletContext);
}