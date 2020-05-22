class Plugin {
    private final Method init;
    private final Method start;
    private final Method stop;
    public Plugin(Class cl) throws PluginException, SecurityException {
        init = cl.getMethod("init");
        if (init == null) {
            throw new PluginException("Plugin is missing init method");
        }
        start = cl.getMethod("start");
        if (start == null) {
            throw new PluginException("Plugin is missing start method");
        }
        stop = cl.getMethod("stop");
        if (stop == null) {
            throw new PluginException("Plugin is missing stop method");
        }
    }
    ...
}