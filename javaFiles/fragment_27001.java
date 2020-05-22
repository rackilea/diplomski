public static void main(final String... args) {
    final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd hh:mm:ss")
            .registerTypeAdapter(Forecast.class, getForecastJsonDeserializer())
            .create();
    final Response response = gson.fromJson(JSON, Response.class);
    System.out.println(response);
}