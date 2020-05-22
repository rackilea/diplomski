private void prepareLog4J2ForRestart() throws Exception {
    if (ClassUtils.isPresent("org.apache.logging.log4j.LogManager",
            getClass().getClassLoader())) {
        LoggerContextFactory factory = LogManager.getFactory();
        Field field = ReflectionUtils.findField(factory.getClass(),
                "shutdownCallbackRegistry");
        ReflectionUtils.makeAccessible(field);
        ShutdownCallbackRegistry shutdownCallbackRegistry = (ShutdownCallbackRegistry) ReflectionUtils
                .getField(field, factory);
        Field hooksField = ReflectionUtils
                .findField(shutdownCallbackRegistry.getClass(), "hooks");
        ReflectionUtils.makeAccessible(hooksField);
        @SuppressWarnings("unchecked")
        Collection<Cancellable> state = (Collection<Cancellable>) ReflectionUtils
                .getField(hooksField, shutdownCallbackRegistry);
        state.clear();
    }
}