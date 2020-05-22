public class MyTestActivator implements BundleActivator {        
    static {
        //Pin first.
        pin = new java.util.logging.Logger[] { 
        java.util.logging.Logger.getLogger(""),
        java.util.logging.Logger.getLogger("3rd.party.package") };

        //Change JUL levels.
        for (java.util.logging.Logger l : pin) {
           l.setLevel(Level.FINEST);
        }
    }

    @Override
    public void start(final BundleContext bundleContext) throws Exception {
        try {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);
            try {
                context.reset();
                configurator.doConfigure(getClass().getResourceAsStream("/logback.xml"));
                //Setup SLF4J
                SLF4JBridgeHandler.removeHandlersForRootLogger();
                SLF4JBridgeHandler.install();
            } catch (JoranException e) {
                throw new IOException(e.getMessage(), e);
            }
            StatusPrinter.printInCaseOfErrorsOrWarnings(context);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}