ObjectMapper mapper = new ObjectMapper();
try {
    List<Result> responseList = mapper.readValue(
            Files.readAllBytes(Paths.get("test.json")),
            new TypeReference<List<List<Student>>>() {});

} catch (IOException e) {
    e.printStackTrace();
}