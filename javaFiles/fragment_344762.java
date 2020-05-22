// Parsing json
for (int i = 0; i < response.length(); i++) {
   try {
   JSONObject obj = response.getJSONObject(i);
   if (obj.getString("tipe").equals("tipe1){
        Movie movie = new Movie();
        movie.setTitle(obj.getString("name"));                                movie.setThumbnailUrl(obj.getString("images1"));

        movie.setYear(obj.getInt("id"));
        movie.setTipe(obj.getString("tipe"));    
        // adding movie to movies array
        movieList.add(movie);
   }

   } catch (JSONException e) {
       e.printStackTrace();
   }

}