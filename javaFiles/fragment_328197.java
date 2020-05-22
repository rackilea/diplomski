String jsonString = "{\"first\":{\"1\":[{\"id\":1,\"name\":\"jo\"}]}}";
    //String jsonString = "{\"first\":{\"1\":[{\"id\":1,\"name\":\"other\"}]}}";

    JSONObject users;
    try {
        users = new JSONObject(jsonString);
        users=users.getJSONObject("first");
        JSONArray sub = users.getJSONArray("1");
        System.out.println(sub.get(0));
    } catch (JSONException e) {

        // TODO Auto-generated catch block
        e.printStackTrace();
    }