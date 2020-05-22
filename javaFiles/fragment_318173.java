String json = "{\"msg\" : \"Hello \n World\"}";
System.out.println(json);

json = json.replaceAll("\r?\n", "");

 Map<String, String> map = new Gson().fromJson(json, new TypeToken<Map<String, String>>(){}.getType());
    System.out.println("Actual message:" + map.get("msg"));