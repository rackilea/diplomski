JSONArray new_array = new JSONArray(string);
for(int i =0; i < new_array.length(); i++){
     JSONArray arr = new_array.getJSONArray(i);
     for(int j =0; j < arr.length(); j++){
          Log.v("result--",""+arr.getString(j));
     }
}