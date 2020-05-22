String jsonString = "{\n" +
                "             \"Structure1\": [\n" +
                "              [\n" +
                "                    \"StringValue1\",\n" +
                "                    \"StringValue2\"\n" +
                "              ],\n" +
                "              [\n" +
                "                    \"StringValue1\",\n" +
                "                    \"StringValue2\"\n" +
                "              ]\n" +
                "            ],\n" +
                "            \"Structure2\": [\n" +
                "              [\n" +
                "                    \"StringValue1\",\n" +
                "                    \"StringValue2\"\n" +
                "              ]\n" +
                "            ],\n" +
                "            \"Structure3\": [\n" +
                "              [\n" +
                "                    \"StringValue1\",\n" +
                "                    \"StringValue2\"\n" +
                "              ]\n" +
                "            ]\n" +
                "        }";

Map<String, ArrayList<String>> myMap = gson.fromJson(jsonString, HashMap.class);