public static void main(String[] args) {
        String jsonData = "{\n"
                + "   \"name\":\"anyname\",\n"
                + "   \"machines\":[\n"
                + "      {\n"
                + "         \"id\":\"771760\",\n"
                + "         \"type\":\"general\",\n"
                + "         \"properties\":{\n"
                + "            \"value1\":\"1\",\n"
                + "            \"value2\":\"2\"\n"
                + "         }\n"
                + "      },\n"
                + "      {\n"
                + "         \"id\":\"341256\",\n"
                + "         \"type\":\"general\",\n"
                + "         \"properties\":{\n"
                + "            \"value1\":\"Need to fetch this value\"\n"
                + "         }\n"
                + "      },\n"
                + "      {\n"
                + "         \"id\":\"341256\",\n"
                + "         \"type\":\"general\",\n"
                + "         \"properties\":{\n"
                + "            \"value1\":\"1\",\n"
                + "            \"value2\":\"2\"\n"
                + "         }\n"
                + "      }\n"
                + "   ]\n"
                + "}";

        final JSONObject jsonObject = new JSONObject(jsonData);
        final JSONArray machines = jsonObject.getJSONArray("machines");
        for (int i = 0; i < machines.length(); i++) {
            final JSONObject machine = machines.getJSONObject(i);
            final JSONObject properties = machine.getJSONObject("properties");
            System.out.println(properties.get("value1"));
        }
    }