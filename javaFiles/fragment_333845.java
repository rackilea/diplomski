private JsonArray serializetechnologies(List<Technology> technologyList) {
    JsonArray jsonArray = new JsonArray();
    for (Technology technology : technologyList) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(technology.getTechnologyId()+"", technology.getTechnologyName());
        jsonArray.add(jsonObject);
    }
    return jsonArray;
}