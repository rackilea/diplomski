public void onStartup(ServletContext container) throws ServletException {
    try (AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext()) {
        ctx.register(BaseConfiguration.class);
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        try {
            LoadModels();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}