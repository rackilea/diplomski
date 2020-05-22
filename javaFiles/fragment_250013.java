JSONObject jsonObject = new JSONObject(response);
JSONObject results = jsonObject.getJSONObject("results");
JSONArray bindings = results.getJSONArray("bindings");
for (int i = 0; i < bindings.length(); i++) {
    JSONObject binding = bindings.getJSONObject(i);
    JSONObject city = binding.getJSONObject("city");
    // Get value in city
    String cityValue = city.getString("value");
    Log.d("CITY", cityValue);
    JSONObject country = binding.getJSONObject("country");
    // Get value in country
    String countryValue = country.getString("value");
    Log.d("COUNTRY", countryValue);
}