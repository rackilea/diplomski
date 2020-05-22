interface Plugin {
    void install(Application application);
}

@Component({ModuleA.class, ModuleB.class})
interface PluginComponent {
    Set<Plugin> plugins();
}

@Module
class ModuleA {
    private final Set<Plugin> plugins;

    ModuleA(Set<Plugin> plugins) {
        this.plugins = plugins;
    }

    @Provides(type = SET_VALUES) Plugin providFooPlugins() {
        return plugins;
    }
}

@Module
class ModuleB {
    @Provides(type = SET) Plugin providBarPlugin() {
        return new BarPlugin();
    }
}