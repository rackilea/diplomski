JsonNode json = request().body().asJson();

for (JsonNode language : json.withArray("languages")) {
    Logger.info("language -> " + language.get("someField").asText());
    //do something else
}