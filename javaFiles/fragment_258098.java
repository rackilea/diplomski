public String getISSInfo(String json) {
    String output = "";
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    JsonParser parser = new JsonParser();
    JsonObject top = parser.parse(json).getAsJsonObject();
    String nested = top.get("iss_position").toString();
    ISSClass cond = gson.fromJson(nested, ISSClass.class);

    output += "The ISS is at: " + cond.toString();
    return output;
}