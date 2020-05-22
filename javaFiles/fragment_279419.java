private static void mergeObjects(JsonObject object, JsonObject modification) {

    // Iterate through the modified properties
    for (Entry<String, JsonElement> entry : modification.entrySet()) {

        JsonElement je = entry.getValue();

        // If the modified property is an object, iterate through the properties of the modified property
        if (je instanceof JsonObject) {

            JsonObject nextOrigObject = object.get(entry.getKey()).getAsJsonObject();
            JsonObject nextModObject = je.getAsJsonObject();

            mergeObjects(nextOrigObject, nextModObject);

        }

        // If the modified property is not an object, set the original object to match the modified property
        else
            object.add(entry.getKey(), je);

    }

}