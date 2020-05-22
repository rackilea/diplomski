public static void main(String[] args) {
    String endpoint = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20"
            + "where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Rhodes%2C%20Gr%22)&"
            + "format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
    try {
        URL endpointURL = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) endpointURL
                .openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();
        JsonReader reader = new JsonReader(new InputStreamReader(input));
        reader.setLenient(true);

        JsonElement forecastSubObject = new JsonParser().parse(reader).
                getAsJsonObject().get("query").
                getAsJsonObject().get("results").
                getAsJsonObject().get("channel").
                getAsJsonObject().get("item").
                getAsJsonObject().get("forecast");  

        System.out.println(forecastSubObject.toString());   

        List<forecast> forecasts = (List<forecast>)new Gson().fromJson(forecastSubObject, List.class);

        System.out.println("forecast : " + forecasts);
        System.out.println("first forecast: " + forecasts.get(0));      
    } catch (IOException e) {
        e.printStackTrace();
    }
}