public void write(String s) throws IOException {
    ValuedWord temp = new ValuedWord(0,0.8,0,0,0,0,0,0);
    ObjectWriter objectWriter = objectMapper.writer().withRootName(s);
    String json = objectWriter.writeValueAsString(temp);
    // Enhance your generator code to handle the json string
    generator.writeObject(json);
}