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
JSONObject followers = jsonObject.getJSONObject("followers");

String options = followers.optString("options");
followers.put("options", options);

String s = XML.toString(jsonObject);
System.out.println(XML.unescape(s));