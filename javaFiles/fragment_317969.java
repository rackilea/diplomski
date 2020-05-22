public static String displayHeader() {
    CsvMapper mapper = new CsvMapper();

    JavaType javaType = mapper.getTypeFactory().constructType(InputSchema.class);
    BeanDescription beanDescription = mapper.getSerializationConfig().introspect(javaType);
    List<BeanPropertyDefinition> properties = beanDescription.findProperties();

    List<String> columnNames = properties.stream()
        .map(e -> e.getName())
        .collect(Collectors.toList());
    String header = String.join("\t", columnNames);

    return header;
}