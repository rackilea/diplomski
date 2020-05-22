public static void parse(String jsonData) {
    ArrayList<Restaurant> restaurantList= new ArrayList<Restaurant>();
    JSONObject jsonObject;
    JSONObject jsonRestaurant;

    try {
        jsonObject= new JSONObject(jsonData);
        for(int i=0;i<3;i++) {
            Restaurant restaurant= new Restaurant();
            jsonRestaurant= jsonObject.getJSONObject(Integer.toString(i));
            restaurant.name= jsonRestaurant.getString("name");
            restaurant.address= jsonRestaurant.getString("address");
            restaurantList.add(restaurant);
        }
    }
    catch(JSONException e) {
        e.printStackTrace();
    }
}