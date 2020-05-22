public void writeJson(){
    try {
        //this line is not needed, since you are reading array & not not json object 
        //JSONObject obj = new JSONObject(loadJSONFromAsset());
        JSONArray response = new JSONArray(loadJSONFromAsset());

        for (int i = 0; i < response.length(); i++) {
            JSONObject jo_inside = response.getJSONObject(i);

            Log.d(TAG, jo_inside.getString("firstName"));

            //Add values in `ArrayList`
            //for setting the values use object read from response array 
            Person person = new Person();
            person.setName(jo_inside.getString("firstName"));
            person.setAge(jo_inside.getString("age"));
            person.setPhoto(jo_inside.getInt("id"));
            // Add to the array
            persons.add(person);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    } 
}