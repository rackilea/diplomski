String str = "[{"category_name":"Food","filter_type":"Sort by","field_name":"","type":"VALUE","table_name":"","item_list":["Ascending","Descending"]}";

JSONArray jsonArray = new JSONArray(str);
//now it holds the JSONObject.
for (int i = 0; i<= jsonArray.length(); i++) {
 //now we loop through and get the jsonObject
 JSONObject jsonObj = new JSONObject(jsonArray.getJsonObject(i));
 //now it contains your data.
 Log.d("Category_nameValue=", jsonObj.getString("category_name"));
 //now we want to get the array from the item_list. 
 JSONArray itemList = new JSONArray(jsonObj.getString("item_list")); 
 //now itemList.getString(1);  === Ascending while itemList.getString(2) == Descending



 //now itemList contains several new objects which can also be looped as the parent one.
}