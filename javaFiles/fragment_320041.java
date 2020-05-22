//make this a class variable
ArrayList<HashMap<String, String>> sList = new ArrayList<HashMap<String, String>>(); 

// Callback detected from the search dialog
// call the search logic
private void handleIntent(Intent intent)
{
    // If the adapter is not null it means it has items in it
    // this means we are re-searching and need to reset the list
    // and adapter
    if (adapter != null)
    {
        sList.clear();
        finish();
        startActivity(intent);
    }

    // If it was the action search intent search yelp
    if (Intent.ACTION_SEARCH.equals(intent.getAction()))
    {
        String query = intent.getStringExtra(SearchManager.QUERY);
        new SearchYelp().execute(query); //execute new thread and call the query
    }
}

 /**
 * Post the results of the SearchYelp thread
 */
private void postResults()
{
    // For every item in the JSON bundle
    // add details from JSON string to a hashmap
    for (int i = 0; i < jsonResponse.getBundleSize(); i++)
    {
        HashMap<String, String> map = new HashMap<String, String>();

        // Yelp result strings, post parsed
        map.put(KEY_NAME, jsonResponse.getBusinessName(i));
        map.put(KEY_DESCRIPTION, jsonResponse.getSnippet(i));
        map.put(KEY_RATINGURL, jsonResponse.getRatingURL(i));
        map.put(KEY_THUMBURL, jsonResponse.getThumbURL(i));
        map.put(KEY_RATINGINT, jsonResponse.getRating(i));

        sList.add(map); //add the hashmap to the list
    }

    adapter = new CustomAdapter(this, sList); //send the details to the data adapter
    setListAdapter(adapter); //set the adapter for this activity as the custom adapter
}