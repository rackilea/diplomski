@Bean
public DispatcherServlet dispatcherServlet() {
    DispatcherServlet servlet = new DispatcherServlet();
    servlet.setDispatchOptionsRequest(true);
    return servlet;
}