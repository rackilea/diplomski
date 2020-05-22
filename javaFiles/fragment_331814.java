@Override
public void contextDestroyed(ServletContextEvent sce) {
    log.debug("contextDestroyed({}) called.", sce);
    deRegisterLog();
}

/**
* Avoiding memory leaks
*
* If your application is deployed in a web-server or an application server,
* the registration of an JMXConfigurator instance creates a reference from the system class loader
* into your application which will prevent it from being garbage collected when it is stopped or re-deployed,
* resulting in a severe memory leak.
*
* Thus, unless your application is a standalone Java application,
* you MUST unregister the JMXConfigurator instance from the JVM's Mbeans server.
* Invoking the reset() method of the appropriate LoggerContext will automatically unregister any
* JMXConfigurator instance. A good place to reset the logger context is in the contextDestroyed()
* method of a javax.servlet.ServletContextListener.
*/
private void deRegisterLog() {
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    log.info("Trying to stop logger factory {}", lc);
    if (lc != null) {
        lc.stop();
    }
}