public ArrayList<Trip> getTripList(String json){
    Trip thisTrip;
    ArrayList<Trip> thisTripList = new ArrayList<Trip>();

    try {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray tripArray = jsonObject.getJSONArray("trips");

        for(int i = 0; i < tripArray.length(); i++){
            JSONObject tripInstance = tripArray.getJSONObject(i);
            thisTrip = new Trip();
            thisTrip.origin = tripInstance.getString("origin");
            thisTrip.destination = tripInstance.getString("destination");

            thisTripList.add(thisTrip);
        }

        return(thisTripList);

    } catch (JSONException e) {
        e.printStackTrace();
        return(null);
    }
}