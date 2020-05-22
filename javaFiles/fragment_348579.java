public List<String> parse(final Gson gson, final String jsonText) {
    final JsonObject json = gson.fromJson(jsonText, JsonObject.class);
    final JsonArray rowsJson = json.getAsJsonArray("rows");

    final List<String> durations = new ArrayList<>(rowsJson.size());

    for (JsonElement row : rowsJson) {
        final JsonArray elements = row
                .getAsJsonObject()
                .getAsJsonArray("elements");

        for (JsonElement element : elements) {
            final JsonObject duration = element
                    .getAsJsonObject()
                    .getAsJsonObject("duration");

            durations.add(duration.getAsJsonPrimitive("text").getAsString());
        }
    }

    return durations;
}