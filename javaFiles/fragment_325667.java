public class CityListDeserializer implements JsonDeserializer<CityList> {

    @Override
    public CityList deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = element.getAsJsonObject();
        List<City> cities = new ArrayList<City>();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            // For individual City objects, we can use default deserialisation:
            City city = context.deserialize(entry.getValue(), City.class); 
            cities.add(city);
        }
        return new CityList(cities);
    }

}