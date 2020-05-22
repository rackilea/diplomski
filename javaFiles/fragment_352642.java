public static void main(String[] args) throws ConfigurationException {
    Configurations configurations = new Configurations();
    XMLConfiguration xmlConfiguration = configurations.xml("config.xml");
    Map<String, Map<String, String>> map = new HashMap<>();
    xmlConfiguration.getNodeModel().getRootNode().getChildren().forEach(x -> {
        Map<String, String> temp = new HashMap<>();
        x.getChildren().forEach(y -> {
            temp.put(y.getAttributes().get("key").toString(), y.getValue().toString());
        });
        map.put(x.getNodeName(), temp);
    });
    System.err.println(map);
}