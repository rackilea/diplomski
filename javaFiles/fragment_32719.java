public Response deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
    Response response = new Gson().fromJson(jsonElement, Response.class);
    Type t = null;
    if (response.getVehicleType().equals(Bus.vehicle_type)) {
        t = Bus.class;
    } else if (response.getVehicleType().equals(Car.vehicle_type)) {
        t = Car.class;
    }
    JsonObject object = jsonElement.getAsJsonObject();
    if (object.has("vehicle")) {
        JsonElement vehicleElement = object.get("vehicle");
        Vehicle vehicle = jsonDeserializationContext.deserialize(vehicleElement, t);
        response.setVehicle(vehicle);
    }
    return response;
}