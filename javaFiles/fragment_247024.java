try {
    JSONArray jArray = new JSONArray(result);
    // get into the 'groups' array
    JSONObject jData = jArray.getJSONObject(0);
    JSONArray jGroupsArray = jData.getJSONArray("groups");
    // get into the 'items' array
    jData = jArray.getJSONObject(2);
    JSONArray jItemsArray = jData.getJSONArray("items");
    // get into the 'categories' array
    jData = jArray.getJSONObject(4);
    JSONArray jCategoriesArray = jData.getJSONArray("categories");
    // get into the 'icon' value as String and use it as you please
    jData = jArray.getJSONObject(4);
    String iconURL = jData.getString("icon");
} catch (JSONException e) {
    Log.e(Constants.LOG_TAG, "Error parsing data", e);
}