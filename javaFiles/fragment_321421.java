Enumeration<URL> enumResources = null;
        try {
            enumResources = cl.getResources(LOGGER_RESOURCE);
        } catch (IOException e) {
            logger.fatal("Unable to locate " + LOGGER_RESOURCE, e);
        }