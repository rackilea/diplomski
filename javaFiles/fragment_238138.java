List<Plugin> plugins = new ArrayList<Plugin>();
Plugin p = new Plugin(); // no need to mock it
p.setArtifactId("maven-surefire-plugin");
Xpp3Dom conf = new Xpp3Dom("configuration");
Xpp3Dom skip = new Xpp3Dom("skip");
skip.setValue("true");
conf.addChild(skip);
p.setConfiguration(conf);
plugins.add(p);

Mockito.when(this.build.getPlugins()).thenReturn(plugins);