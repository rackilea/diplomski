public class GsonTestApplication {
    public static void main(String[] args) {
        final Gson gson = new GsonBuilder().(LocalDateTime.class, new LocalDateTimeDeserializer("yyyy-MM-dd HH:mm:ss.SSSSSSx")).create();
        final String responseJSON = "{ \"timestamp\":\"2017-11-09 11:07:20.079364+00\" }";
        final JSONClass foo = gson.fromJson(responseJSON, new TypeToken<JSONClass>(){}.getType());
        System.out.println(foo.getTimestamp().toString());
    }
}