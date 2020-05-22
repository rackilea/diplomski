public void toJSON(String description, String Name){
    JSONObject inner = new JSONObject();
    JSONObject inner2 = new JSONObject();
    JSONObject inner3 = new JSONObject();
    JSONArray array = new JSONArray();

    try{
        array.put(inner);
        inner.put("description", description);
        inner.put("filename", imageName);

        array.put(inner2);
        inner2.put("model", "modelname");

        array.put(inner3);
        inner3.put("Datetime", "DateTime");

        outer.put("values", array);

    } catch(JSONException ex){
        ex.printStackTrace();
    }
}