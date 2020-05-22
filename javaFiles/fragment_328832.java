private JsonObjectBuilder jsonObjectToBuilder(JsonObject jo) {
    JsonObjectBuilder job = Json.createObjectBuilder();

    for (Entry<String, JsonValue> entry : jo.entrySet()) {
        job.add(entry.getKey(), entry.getValue());
    }

    return job;
}