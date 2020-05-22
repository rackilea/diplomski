try{
       JSONObject o = new JSONObject(json);
       JSONArray restaurants = o.getJSONArray("restaurant");
       for(int i = 0; i < restaurants.length(); i++){
           JSONObject restaurant = restaurants.getJSONObject(i);
           JSONArray ratings = restaurant.getJSONArray("rating");
           for(int j = 0; j < ratings.length(); j++){
               JSONObject rating = ratings.getJSONObject(j);
               String ratingId = rating.getString("ratingId");
               Log.d("TestJson ratingId", ratingId);
               String rate = rating.optString("rate");
               Log.d("TestJson rate", rate);
           }
       }
   }catch(Exception e){
        e.printStackTrace();
   }