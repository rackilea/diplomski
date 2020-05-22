public static void main(String[] args) {
    Map<String, Object> root = new LinkedHashMap<>();
    Map<String, Object> mart = new LinkedHashMap<>();

    Map<String, Object> details = new LinkedHashMap<>();
    details.put("name", "Koushik");
    details.put("purpose", "yaml generation for testing");
    details.put("owner", Arrays.asList(
            Map.of("name", "Bobby", "email", "bd@abc.com"),
            Map.of("name", "Chaminda", "email", "cv@def.com")
    ));

    mart.put("details", details);
    root.put("mart", mart);

    DumperOptions options = new DumperOptions();
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
    Yaml yaml = new Yaml(options);
    System.out.println(yaml.dump(root));
}