TypeReference<Set<Test>> ref = new TypeReference<Set<Test>>() {};
try {
    new ObjectMapper().readValue("[{\"id\":123,\"name\":\"Abc\"},{\"id\":124,\"name\":\"EDF\"}]", ref);
} catch (IOException ignored) {
    // stub
}