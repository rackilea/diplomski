public static Boolean allowInternalLogging() {
    if (internalLogging == null) {
        try {
            internalLogging = inNetwork();
        } catch (Exception e) {
            internalLogging = false;
            LOGGER.debug("Could not determine logging granularity", e);
        }
    }
    return internalLogging;
}