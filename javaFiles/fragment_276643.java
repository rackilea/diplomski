String input = "{\"SQN\":922,\"Node_ID\":\"cc000000000000000000000000000002\",\"Energy\":\"5.00\",\"Power\":\"1.80\",\"Sign\":\"6d226becaf5a5b...\"}";

    JsonObject obj = new JsonParser().parse(input).getAsJsonObject();
    String sqnString = jsonObjectToString(obj, "SQN");
    String energyString = jsonObjectToString(obj, "Energy");
    String powerString = jsonObjectToString(obj, "Power");
    String signString = jsonObjectToString(obj, "Sign");

    StringBuilder sb = new StringBuilder();
    sb.append("{whatever you need}").append(sqnString).append("{whatever you need here}").append(energyString).append("{something else}").append(powerString);
    String part_1 = sb.toString();
    String part_2 = signString;

    System.out.println(part_1);
    System.out.println(part_2);
}

private static String jsonObjectToString(JsonObject obj, String name) {
    return obj.getAsJsonPrimitive(name).getAsString();
}