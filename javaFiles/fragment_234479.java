public class Main {

    public static void main(String[] args) throws IOException {

        String json = "{\n" +
                "    \"code\": 1012,\n" +
                "    \"status\": \"sucess\",\n" +
                "    \"message\": \"Datos Del Usuario\",\n" +
                "    \"time\": \"28-10-2015 10:42:04\",\n" +
                "    \"data\": {\n" +
                "        \"id_hash\": 977417640,\n" +
                "        \"user_name\": \"Daniel\",\n" +
                "        \"user_surname\": \"Hdz Iglesias\",\n" +
                "        \"birthdate\": \"1990-02-07\",\n" +
                "        \"height\": 190,\n" +
                "        \"weight\": 80,\n" +
                "        \"sex\": 2\n" +
                "    }\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Date.class, new BirthdayDeserializer());
        mapper.registerModule(module);
        User readValue = mapper.readValue(json, User.class);
    }
}