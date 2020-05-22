@Override
public void contextInitialized(ServletContextEvent event) {
    ServletContext context = event.getServletContext();
    Set<String> ips = parseContextParamSomehow(context.getInitParam("ips"));
    Manager manager = new Manager();
    manager.setIps(ips);
    context.setAttribute("manager", manager);
}