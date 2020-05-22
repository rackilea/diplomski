public static ArrayList<MovieItem> getSimpleMovieStringsFromJson(Context context, String moviesJsonString)
        throws JSONException {

    final String RESULTS = "results";
    final String POPULARITY = "popularity";
    final String POSTER_PATH = "poster_path";
    final String ORIGINAL_TITLE = "original_title";

    ArrayList<MovieItem> moviesItemsList = new ArrayList<MovieItem>();

    JSONObject moviesObject = new JSONObject(moviesJsonString);
    JSONArray moviesItemsList = moviesObject.getJSONArray(RESULTS);

    for(int i = 0; i < moviesItemsList.length; i++)
    {

        JSONObject object = moviesItemsList.getJSONObject(i);
        MovieItem ci = new MovieItem();
        String original_title = object.getString(ORIGINAL_TITLE);
        ci.toString(original_title);
        moviesItemsList.add(ci);
    }

    return moviesItemsList;
}