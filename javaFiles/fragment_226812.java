public static String toJson(Person person, Gson gson) {
    JsonObject object = gson.toJsonTree(person).getAsJsonObject();
    // Checks whether Person was PersonDecorator or not
    if (object.has("person")) {
      return object.get("person").toString();
    } else {
      return object.toString();
    }
}