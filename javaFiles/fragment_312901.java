String json = "[{\"username\":\"Hello\",\"email\":\"hello@email.com\",\"credits\":\"100\",\"twitter_username\":\"\"},{\"username\":\"Goodbye\",\"email\":\"goodbye@email.com\",\"credits\":\"0\",\"twitter_username\":\"\"}]";
JsonArray jArray = new JsonParser().parse(json).getAsJsonArray();
for (int i=0;i<jArray.size();i++) {
    JsonObject jsonObject = jArray.get(i).getAsJsonObject();
    System.out.println(jsonObject.get("username"));
    System.out.println(jsonObject.get("email"));
    System.out.println(jsonObject.get("credits"));
    System.out.println(jsonObject.get("twitter_username"));
    System.out.println("*********");
}