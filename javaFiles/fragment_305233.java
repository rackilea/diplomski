try {
    mapper.writeValue(wr, content);
} catch (JsonMappingException e) {
    e.printStackTrace();
} catch (JsonGenerationException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}