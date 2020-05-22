Gson gson = new Gson();
JsonElement data = gson
        .fromJson("  {\n" + "    \"message\": \"someName someLastName has sent you a question\",\n"
                + "    \"parameters\": \"{\\\"firstName\\\":\\\"someName\\\",\\\"lastName\\\":\\\"someLastName\\\"}\",\n"
                + "    \"id\": 141\n" + "  }", JsonElement.class);
String jsonString = data.getAsJsonObject().get("parameters").getAsJsonPrimitive().getAsString(); 
JsonObject parameters = gson.fromJson(jsonString, JsonObject.class);
System.out.println(parameters);