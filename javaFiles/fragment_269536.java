protected Map<String, String> getParams()
{
   Map<String, String>  params = new HashMap<String, String>();
   params.put("user_id", userID );
   Map<String, String>  foodOrder = new HashMap<String, String>();
   foodOrder.put("id",productID);
   foodOrder.put("item_count",numberOfItems.getText().toString());
   Gson gson = new Gson();
   params.put("product", gson.toJson(foodOrder));
   Arrays.deepToString(new JSONObject[]{new JSONObject(params)});
   return params;
 }