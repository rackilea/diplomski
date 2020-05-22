int criticsScore;
    try {
        criticsScore = myJsonObject.getJSONArray("movies").getJSONObject(0).getJSONObject("ratings").getInt("critics_score");
    } catch (JSONException e) {
        e.printStackTrace();
    }