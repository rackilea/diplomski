Set<Plugin> plugins = new HashSet<>();
plugins.add(new AwesomePlugin());
plugins.add(new BoringPlugin());
DaggerPluginComponent.builder()
    .moduleA(new ModuleA(plugins)
    .build();