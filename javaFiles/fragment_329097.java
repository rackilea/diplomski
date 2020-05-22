public static void main(String[] args) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    String source1 = "{\n" +
            "    \"channel\" : \"JHBHS\"\n" +
            "}";
    String source2 = "{\n" +
            "    \"channel\": {\n" +
            "                    \"id\": 12321,\n" +
            "                    \"name\": \"Some channel\"\n" +
            "               }\n" +
            "}";

    //Test object parsing
    Event result = objectMapper.readValue(source2, Event.class);
    System.out.println(String.format("%s : %s", result.getChannel().getId(), result.getChannel().getName()));

    //Test string parsing
    result = objectMapper.readValue(source1, Event.class);
    System.out.println(result.getChannelStr());
}