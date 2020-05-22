final Map<String, String> map1 = new HashMap<String, String>() {
  {
    put("abc", "def");
  }
};
Gson gson = new Gson();
String json = gson.toJson(map1, new TypeToken<Map<String, String>>() {}.getType()); // {"abc":"def"}