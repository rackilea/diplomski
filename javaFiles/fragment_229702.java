JSONObject obj;
JSONArray cartitems = new JSONArray();
  for (int i=0; i < listProducts.size(); i++) {
     obj = new JSONObject();
     try {
         obj.put("id", id);
         obj.put("quantity", quantity);
         cartitems.put(obj);
     }catch (JSONException e) {
         throw new RuntimeException(e);
         }
     }