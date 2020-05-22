@Bean
public JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory(@Value("${server.port:8080}") final String port) {

    JettyEmbeddedServletContainerFactory factory =  new JettyEmbeddedServletContainerFactory(Integer.valueOf(port));

    //enable thread pool with stats
    factory.setThreadPool(new MonitoredQueuedThreadPool());

    //enable JMX
    factory.addServerCustomizers(server -> {
        MBeanContainer mbContainer=new MBeanContainer(ManagementFactory.getPlatformMBeanServer());
        server.addEventListener(mbContainer);
        server.addBean(mbContainer);
        server.addBean(Log.getLog());

    });

    return factory;
}