//Create array 
    Map map = new LinkedHashMap();
    JSONArray jArray = new JSONArray();

    map.put("id", "asdf");
    map.put("name", "bbbdasfadsbb");
    map.put("address", "sadfasdfasdf");
    map.put("phone", "asdfdsafsdf");
    map.put("details", "asdasdf");
    map.put("randomText", "sdafasdfs");

    jArray.put(map);

    //You can write this string out to a hidden field
    //called mapAsJSONArray
    String mapAsJSONArray = jArray.toJSONString();

    //.......
    //Then in your servlet....   
    String mapAsJSONArray = request.getParameter("mapAsJSONArray");
    JSONArray jsonArray = new JSONArray(mapAsJSONArray);

    for (int i = 0; i < jsonArray.length(); ++i) {
        JSONObject obj = jsonArray.getJSONObject(i);
        String id = obj.getString("id");
        // ...
    }