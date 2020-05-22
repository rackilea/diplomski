// Get some JSON from wherever
 String json = getJSONFromServer();

 // Parse the JSON response into an object
 JSONObject object = new JSONObject(json);

 // Get the results array
 JSONArray users = object.getJSONArray("results");
 for(int i = 0; i < users.length(); i++) {
     // Each element in the results array is a JSONObject with a single
     // property "user" which is a JSONObject that contains the user data
     JSONObject user = users.getJSONObject(i).getJSONObject("user");

     // Do something with the user
     String firstName = user.getString("first_name");
 }