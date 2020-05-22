JSONArray names = airports.names();
Log.d("Length Array 0", String.valueOf(names.length()));
Log.d("Length Array 1", String.valueOf(arrayAirports.size()));
for(int i = 0; i<names.length(); i++){
    JSONObject jsonAirport = airports.getJSONObject(names.getString(i));
    // code
}