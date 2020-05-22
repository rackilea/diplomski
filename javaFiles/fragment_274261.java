package com.example.my;
//

public class Application {

    public static void main(String[] args) throws Exception {

        // reconfigure JUL for slf4j
        LogManager.getLogManager().reset();
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        Logger.getLogger("global").setLevel(Level.FINEST);

        // about to check for verbose output request
        if ( isVerboseOutputRequested() ) {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

            try {
              JoranConfigurator configurator = new JoranConfigurator();
              configurator.setContext(context);
              // Call context.reset() to clear any previous configuration, e.g. default 
              // configuration. For multi-step configuration, omit calling context.reset().
              context.reset(); 
              configurator.doConfigure( getClass().getResourceAsStream("/logback-verbose.xml") );
            }
            catch (JoranException je) {
              // StatusPrinter will handle this
            }
            StatusPrinter.printInCaseOfErrorsOrWarnings(context);
        }

       startApplication(); 
    }

    // ... implement isVerboseOutputRequested() and startApplication()
}