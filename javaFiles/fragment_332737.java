static {
    // (...)
    // if there is no default init override, then get the resource
    // specified by the user or the default config file.
    if (override == null || "false".equalsIgnoreCase(override)) {
        // (...)
        URL url = null;

        // (...)    
        // If we have a non-null url, then delegate the rest of the
        // configuration to the OptionConverter.selectAndConfigure method.
        if (url != null) {
            LogLog.debug("Using URL [" + url + "] for automatic log4j configuration.");
            OptionConverter.selectAndConfigure(
                url, configuratorClassName, LogManager.getLoggerRepository()
            );
        } else {
            LogLog.debug("Could not find resource: [" + configurationOptionStr + "].");
        }
    }
}