public class InitialContextFactory implements javax.naming.spi.InitialContextFactory {
    // code
    private static final String REMOTE_NAMING_EJB_CLIENT_HANDLER_CLASS_NAME = "org.jboss.naming.remote.client.ejb.RemoteNamingStoreEJBClientHandler";
    // code
        try {
            klass = classLoader.loadClass(REMOTE_NAMING_EJB_CLIENT_HANDLER_CLASS_NAME);
            method = klass.getMethod("setupEJBClientContext", new Class<?>[] {Properties.class, List.class});
        } catch (Throwable t) {
            logger.warn("EJB client integration will not be available due to a problem setting up the EJB client handler", t);
        }
    // other code
}