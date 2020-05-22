String res = "[\n" +
        "    {\n" +
        "        \"message\": {\n" +
        "            \"type\": \"String\",\n" +
        "            \"value\": \"Msg1,Msg2,Msg3,Msg4\",\n" +
        "            \"valueInfo\": {}\n" +
        "        },\n" +
        "        \"Decision\": {\n" +
        "            \"type\": \"Boolean\",\n" +
        "            \"value\": false,\n" +
        "            \"valueInfo\": {}\n" +
        "        }\n" +
        "    },\n" +
        "    {\n" +
        "        \"message\": {\n" +
        "            \"type\": \"String\",\n" +
        "            \"value\": \"[Msg2, Msg3,Msg5]\",\n" +
        "            \"valueInfo\": {}\n" +
        "        },\n" +
        "        \"Decision\": {\n" +
        "            \"type\": \"Boolean\",\n" +
        "            \"value\": false,\n" +
        "            \"valueInfo\": {}\n" +
        "        }\n" +
        "    }\n" +
        "]";

try {
    JSONArray jsonArray = new JSONArray(res);

    JSONObject[] messages = new JSONObject[jsonArray.length()];
    JSONObject[] Decision = new JSONObject[jsonArray.length()];


    for(int i =0; i<jsonArray.length(); i++){
        messages[i] = ((JSONObject) (jsonArray.get(i))).getJSONObject("message");
        Decision[i] = ((JSONObject) (jsonArray.get(i))).getJSONObject("Decision");


    }
} catch (JSONException e) {
    e.printStackTrace();
}