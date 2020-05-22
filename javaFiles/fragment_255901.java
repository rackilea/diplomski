public String toJson() {
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    StringWriter stringEmp = new StringWriter();
    try {
        objectMapper.writeValue(stringEmp, this);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return stringEmp.toString();
}