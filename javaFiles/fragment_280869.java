@Bean
public Node elasticSearchTestNode() throws NodeValidationException {
    Node node = new MyNode(
            Settings.builder()
                    .put("transport.type", "netty4")
                    .put("http.type", "netty4")
                    .put("http.enabled", "true")
                    .put("path.home", "elasticsearch-data")
                    .build(),
            asList(Netty4Plugin.class));
    node.start();
    return node;
}

private static class MyNode extends Node {
    public MyNode(Settings preparedSettings, Collection<Class<? extends Plugin>> classpathPlugins) {
        super(InternalSettingsPreparer.prepareEnvironment(preparedSettings, null), classpathPlugins);
    }
}