public void onStartup(ServletContext servletContext) throws ServletException {


 AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();

        //adding your main config class 
        rootContext.register(WebAppConfig.class);

        //adding your security config class
        rootContext.register(SecurityConfiguration.class);
...

}