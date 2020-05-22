public class ResponseDeserializer implements JsonDeserializer<Response> {

    public Response deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) {

        JsonElement elementField = json.getAsJsonObject().get("element");

        List<Element> elementList = new ArrayList<>();

        if (elementField.isJsonArray()) {
            for (JsonElement item : elementField.getAsJsonArray()) {
                elementList.add(ctx.deserialize(item, Element.class));
            }
        } else if (elementField.isJsonObject()) {
            elementList.add(ctx.deserialize(elementField, Element.class));
        }

        Response response = new Response(elementList);

        return response;
    }
}