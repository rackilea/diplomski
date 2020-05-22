while(res.next()){

    String Name=res.getString("name");
    jsonObject = new JSONObject();
    // ^^^^^^^^
    jsonObject.put("Name", res.getString(1));
    jsonObject.put("age", res.getString(2));
    jsonObject.put("gender", res.getString(3));
    jsonObject.put("Place", res.getString(4));
    ja.put(jsonObject);
 }