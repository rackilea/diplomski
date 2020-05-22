public List<String> parse(final Gson gson, final String jsonText) {
    final JsonObject json = gson.fromJson(jsonText, JsonObject.class);

    return StreamSupport
            .stream(json.getAsJsonArray("rows").spliterator(), false)
            .map(row -> row.getAsJsonObject().getAsJsonArray("elements"))
            .flatMap(elements -> StreamSupport.stream(elements.spliterator(), false))
            .map(element -> element.getAsJsonObject().getAsJsonObject("duration"))
            .map(duration -> duration.getAsJsonPrimitive("text").getAsString())
            .collect(Collectors.toList());
}