JSONArray js_data = [["New Zealand","Auckland","1640","8.795731707317072","516.4469512195122"],["New Zealand","Wellington","1314","8.428462709284627","580.3302891933029"]];
int lenght = js_data.length();
JSONArray city;
for(int i=0;i<length;i++) {
    //get each city
    city = js_data.getJSONArray(i);
    String nameCity = city.getString(0);
    String pop = city.getString(4);
    //Create a object JSON or whatever you want with this data
    JSONArray js_array = new JSONArray();       
    js_array.put(city); js_array.put(pop);
    //And put on a list
    js_map.put(js_array);
}