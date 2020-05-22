public class Application {
    public static void main(String[] args) {
        SimpleModule myModule = new SimpleModule();
        myModule.addSerializer(new LocalDateTimeWithNanoSerializer());
        ObjectMapper objectMapper = new ObjectMapper()
              .registerModule(new JavaTimeModule())
              .registerModule(myModule)
    }
}