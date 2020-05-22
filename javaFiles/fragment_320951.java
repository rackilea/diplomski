private String GetBeerDataFromJSON(int position, String whatToGet) {
    String whatIsTheKeyYouAreLookFor = whatToGet;
    int whereInTheJSONArrayForLoopIsTheData = position;

    String holder = "";


    try{
        holder = json.getJSONArray("data").getJSONObject(whereInTheJSONArrayForLoopIsTheData).getString(whatIsTheKeyYouAreLookFor);

    } catch (JSONException e) {
        holder = "";
    }



    return holder;
}