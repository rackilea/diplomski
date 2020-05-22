List<CurrentMovie> moviesList = new ArrayList<>();
    MovieAdapter mAdapter;

 // Now on response change code as below

   if (response.isSuccessful()) {

        manageJson(json);
    }



public void manageJson(String result)
{
   try
   {
        movieList = new ArrayList<>();
       JsonArray jsonArray = new JSONArray(result);

       for(int i = 0; i < jsonArray.length(); i++)
       {
             JSONObject jsonObject = jsonArray.getJsonObject(i);

             String Title = obj.getString("Title");
             String imgg = obj.getString("PosterPath");
              Currentmovie c = new Currentmovie();

              c.setImageView(imgg);
              c.setTitle(Title);

              movieList.add(c);                 
       }

       mAdapter = new MovieAdapter(YourActivityName.this, movieList);
       listViewObject.setAdapter(mAdapter);
   }
   catch(Exception e)
   {
       System.out.println("Error in Result as " + e.toString());
   }
}