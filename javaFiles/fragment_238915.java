Build build = super.getProject().getBuild();
if (null != build) {
    List<Plugin> plugins = build.getPlugins();
    for (Plugin plugin : plugins) {
        List<Dependency> dependencies = plugin.getDependencies();
        // you can then use your custom code here or just collected them for later usage. 
        // An example of what you can get, below
        for (Dependency dependency : dependencies) {
            getLog().info(dependency.getGroupId());
            getLog().info(dependency.getArtifactId());
            getLog().info(dependency.getVersion());
            getLog().info(dependency.getClassifier());
            getLog().info(dependency.getScope());
            // etc.
        }
    }
}