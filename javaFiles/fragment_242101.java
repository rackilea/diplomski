public Object resolve(Object input, String expression) {
    // Get the mapper with default config.
    ObjectMapper mapper = new ObjectMapper();

    // Make the object traversable by JSONPath.
    Map<String, Object> mappedObject = mapper.convertValue(input, Map.class);

    // Evaluate that expression
    Object output = JsonPath.read(mappedObject, expression);

    return output;
}