String json = "{\"username\":[\"emmet\"]}";
    Gson gson = new GsonBuilder().create();
    Map<String,List<String>> map = new HashMap<>();
    map  = (Map<String,List<String>>)gson.fromJson(json, map.getClass());
    List<String> usernames = map.get("username");
    String[] val = usernames.toArray(new String[0]);
    System.out.println(val);