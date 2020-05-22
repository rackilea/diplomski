public void onApiResponse(String response) {
    // Create a JSONArray from the response
    JSONArray jsonArray = new JSONArray(response);

    // Create a structure to store all of the categories
    List<Category> categories = new ArrayList<Category>();

    // Loop through the array and parse all the categories
    for (int i = 0; i < jsonArray.length(); i++) {
        // Extract the JSONObject from the index
        JSONObject jsonCategory = jsonArray.getJSONObject(i);

        // Add the category to the list
        categories.add(Category.fromJSON(jsonCategory));
    }

    // Do something with your categories...
}