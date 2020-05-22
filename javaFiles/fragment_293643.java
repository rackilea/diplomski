JSONArray arr = new JSONArray();

 while ((line = input.readLine()) != null) {
    JSONObject obj = new JSONObject();
    obj.put("value",line);
    arr.add(obj);
}