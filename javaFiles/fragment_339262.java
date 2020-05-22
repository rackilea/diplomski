public class App {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.setDateFormat(new SimpleDateFormat("dd.MM.yyyy"));
        try {
            final Object value = objectMapper.readValue(App.class.getResource("test.yml"), new TypeReference<List<Map<String, Object>>>() {
            });

            System.out.println(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}