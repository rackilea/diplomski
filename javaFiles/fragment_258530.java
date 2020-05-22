String json = "{\n" +
        "   \"user\": \"gerry\",\n" +
        "   \"likes\": [1, 2, 4],\n" +
        "   \"followers\": {\n" +
        "      \"options\": {\n" +
        "        \"key1\": \"a\",\n" +
        "        \"key2\": \"b\"\n" +
        "      }        \n" +
        "   }\n" +
        "}";

JSONObject jsonObject = new JSONObject(json);
jsonObject.put("followers", jsonObject.optString("followers"));

// org.json 20180813
String s = XML.toString(jsonObject);
System.out.println(XML.unescape(s));