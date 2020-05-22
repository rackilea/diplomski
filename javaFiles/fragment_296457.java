public static Category fromJSON(JSONObject jsonObject) {
    try {
        Category category = new Category();
        category.mCategoryID = jsonObject.getInt("id");
        category.mCategoryName = jsonObjectgetString("name");

        return category;
    } catch (JSONException e) {
        e.printStackTrace();
        return null;
    }
}