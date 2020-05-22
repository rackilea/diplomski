@Bean
public DispatcherServlet dispatcherServlet() {
    DispatcherServlet servlet=new DispatcherServlet();
    servlet.getServletContext().addListener(new ExecutorListener());
    return  servlet;
}

@Bean
public ServletRegistrationBean dispatcherServletRegistration() {
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet(), "/rest/v1/*");
    registrationBean
            .setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);


    return registrationBean;
}