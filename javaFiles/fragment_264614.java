class Plugin {
    private final Method init;
    private final Method start;
    private final Method stop;
    public Plugin(Class cl) throws PluginException, SecurityException {
        try {
            init = cl.getMethod("init");
            start = cl.getMethod("start");
            stop = cl.getMethod("stop");
        } catch (NoSuchMethodException ex) {
            throw new PluginException("Plugin is missing a required method", ex);
        }
    }
    ...
}