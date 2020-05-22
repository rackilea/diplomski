public static void main(String[] args) throws FileNotFoundException {
    Yaml yaml = new Yaml();
    Reader yamlFile = new FileReader("./config.yaml");

    Map<String , Object> yamlMaps = (Map<String, Object>) yaml.load(yamlFile);

    System.out.println(yamlMaps.get("Browser"));
    final List<Map<String, Object>> module_name = (List<Map<String, Object>>) yamlMaps.get("Module Name");
    System.out.println(module_name);
    System.out.println(module_name.get(0).get("ABC"));
    System.out.println(module_name.get(1).get("PQR"));
}