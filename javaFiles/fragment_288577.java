private static void parseJson(JSONObject object) throws JSONException {
    if (object!=null) {
        JSONObject airportResource = object.getJSONObject("AirportResource");
        JSONObject airports = airportResource.getJSONObject("Airports");
        JSONArray airportArray = airports.getJSONArray("Airport");

        for (int i = 0 ; i < airportArray.length(); i++) {
            JSONObject airport = (JSONObject) airportArray.get(i);

            //System.out.println(airport);

            System.out.println("CityCode: " + airport.getString("CityCode"));
        }

    }
    else{
        //null

    }
}