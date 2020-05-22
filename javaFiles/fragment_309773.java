public class Test {

  public static void main(String[] args) throws IOException {


    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    String content = "{\n"
        + "  \"entities\": [\n"
        + "    {\n"
        + "      \"type\": \"fio\",\n"
        + "      \"value\": {\n"
        + "        \"firstName\": \"first\",\n"
        + "        \"lastName\": \"last\"\n"
        + "      }\n"
        + "    },\n"
        + "\n"
        + "    {\n"
        + "      \"type\": \"geo\",\n"
        + "      \"value\": {\n"
        + "        \"country\": \"the country\",\n"
        + "        \"city\": \"the city\"\n"
        + "      }\n"
        + "    },\n"
        + "\n"
        + "    {\n"
        + "      \"type\": \"number\",\n"
        + "      \"value\": 100\n"
        + "    },\n"
        + "\n"
        + "    {\n"
        + "      \"type\": \"number\",\n"
        + "      \"value\": 3.14\n"
        + "    }\n"
        + "  ]\n"
        + "}";

    Entities test = mapper.readValue(content, Entities.class);

    System.out.println(mapper.writeValueAsString(test));


  }

}