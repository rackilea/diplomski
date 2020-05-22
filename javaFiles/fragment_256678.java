for (JsonElement e : myArray)
{
    // Access the element as a JsonObject
    JsonObject jo = e.getAsJsonObject();

    // Get the `timestamp` element from the object
    // since it's a number, we get it as a JsonPrimitive
    JsonPrimitive tsPrimitive = jo.getAsJsonPrimitive("timestamp");

    // get the primitive as a Java long
    long timestamp = tsPrimitive.getAsLong();
    System.out.println("Timestamp: " + timestamp);
}