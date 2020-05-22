public static void main(String[] args) throws IOException {
        String s = Files.lines(Paths.get("src/main/resources/data.json")).collect(Collectors.joining());

        ObjectMapper objectMapper = new ObjectMapper();

        SomeClass someClass = objectMapper.readValue(s, SomeClass.class);

        System.out.println(someClass.getProperty().getFirst());
        System.out.println(someClass.getProperty().getSecond());

    }