// Parse server response to JsonObject
JsonObject movieResultWrapper = (JsonObject) Jsoner.deserialize(jsonResponse);

// Get JsonArray link to "results" key 
JsonArray movieResult = (JsonArray) movieResultWrapper.get("results");

// Iterate over your JsonArray and process data
for (int i = 0; i < movieResult.size(); i++) {
    JsonObject movie = (JsonObject) movieResult.get(i);

    // Be careful in your code your are trying to get "object" and "page" but these keys do not exist!
    // String object = movie.getString("object");
    // int page = movie.getInteger("page");

    // All others parsing look good
    String poster_path = movie.getString("poster_path");
    boolean adult = movie.getBoolean("adult");
    String overview = movie.getString("overview");
    String release_date = movie.getString("realese_date");
    int id = movie.getInteger("id");
    String original_title = movie.getString("original_title");
    String original_lang = movie.getString("original_language");
    String title = movie.getString("tite");
    double pop = movie.getDouble("popularity");
    int vote = movie.getInteger("vote_count");
    boolean video = movie.getBoolean("video");
    // PRINT DATA
    // System.out.printf(object +"   "+  page + "\n");
    System.out.printf("%s %s B: %6.3f S: %6.3f [Q:1]\n", poster_path, adult, overview, release_date, id, original_title, original_lang, title, pop, vote, video);
}