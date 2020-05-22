String s = response.toString();
JsonArray json = JsonArray.readFrom(s);
for (int i = 0; i < json.size(); i++) {
    JsonObject show = json.get(i).asObject();
    int episode = show.get("episode").asInt();
    String time = show.get("first_aired_iso").asString();
    System.out.println("Episode " + episode + " - " + time);
}