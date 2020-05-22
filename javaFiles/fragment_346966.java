String getParam(String code, String element){
    try {
           String base = this.getItembyID(code);
           JSONObject product = new JSONObject(base);
          JSONArray jarray = product.getJSONArray("item");
         String param =  jarray.getJSONObject(0).getString("name");
  return param;
    } catch (JSONException e) {
        e.printStackTrace();
        return "error";
    }
    }