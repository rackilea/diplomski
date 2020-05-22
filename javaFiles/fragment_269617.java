Settings.Builder settings = Settings.settingsBuilder();
settings.put("path.data", "/some/path/data");
settings.put("path.home", "/some/path/home");
settings.put("http.port", 9299);
settings.put("transport.tcp.port", 9399);

// Construct Node without NodeBuilder
List<Class<? extends Plugin>> classpathPlugins = ImmutableList.of(ReindexPlugin.class);
settings.put("node.local", false);
settings.put("cluster.name", "testcluster");
Settings preparedSettings = settings.build();
node = new ExposedNode(InternalSettingsPreparer.prepareEnvironment(preparedSettings, null), Version.CURRENT, classpathPlugins);
node.start();