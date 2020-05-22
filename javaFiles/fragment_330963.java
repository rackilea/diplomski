static final Type listOfMetricsType = new TypeToken<List<DataTransactionMetrics>>() {}.getType();

private List<DataTransactionMetrics> loadMetrics(String url) {
    String jsonString = restTemplate.getForObject(URLA, String.class);

    JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
    JsonArray jarr = json.getAsJsonObject("aggRecords").getAsJsonArray("reportRecords");

    return gson.fromJson(jarr, listOfMetrics);
}

public static void main(String[] args) {
    List<DataTransactionMetrics> metrics = loadMetrics(URLA);
    metrics.addAll(loadMetrics(URLB));

    // metrics now contains all metrics (from URLA and URLB)
}