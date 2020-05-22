public static synchronized PySystemState doInitialize(Properties preProperties,
                                                 Properties postProperties,
                                                 String[] argv,
                                                 ClassLoader classLoader,
                                                 ExtensiblePyObjectAdapter adapter) {
        if (initialized) {
            return Py.defaultSystemState;
        }
        initialized = true;
...