private void parseResult(String result) {
    try {

        JSONArray ar = new JSONArray(result);

        feedsList = new ArrayList<>();

        for (int i = 0; i < ar.length(); i++) {
            JSONObject obj = ar.getJSONObject(i);
            ItemObjects item = new ItemObjects();

            item.setCinemaName(obj.optString("CinemaName"));
            item.setContact(obj.optString("Contacts"));

            //Here you have another Movie Json Array so get it in JSONArray
            JSONArray movieArray =obj.getJSONArray("Movie");

            //get the first object of Movie  JSONArray and use it.
            JSONObject movieObject=movieArray.getJSONObject(0);


            item.setMovieName(movieObject.optString("MovieName"));


            //This JSOn object to get SHOWTIME object
            JSONObject showTime=movieObject.getJSONObject("ShowTime");

            item.setMonday(showTime.optString("Monday"));
            item.setCinemaxPhoto(showTime.optString("Tuesday"));

            item.setSynopsis(movieObject.optString("Synopsis"));
            item.setPhoto(movieObject.optString("photo"));

            feedsList.add(item);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }
}