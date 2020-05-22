interface Plugin {
    void install(Application application);
}

@Component({ModuleA.class, ModuleB.class})
interface PluginComponent {
    Set<Plugin> plugins();
}

@Module
class ModuleA {
    @Provides(type = SET) Plugin providFooPlugin() {
        return new FooPlugin();
    }
}

@Module
class ModuleB {
    @Provides(type = SET) Plugin providBarPlugin() {
        return new BarPlugin();
    }
}