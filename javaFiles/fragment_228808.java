public abstract class PluginManager {
    public PluginManager() {
        pluginLoader = MakeClassLoader();
    }
    ...
    protected abstract PluginClassLoader MakeClassLoader();
}
public class ServiceManager extends PluginManager {
    ...
    protected abstract PluginClassLoader MakeClassLoader() {
        return new ServiceClassLoader();
    }
}
public class ChannelManager extends PluginManager {
    ...
    protected abstract PluginClassLoader MakeClassLoader() {
        return new ChannelClassLoader();
    }
}