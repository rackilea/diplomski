try {
        JSONObject object=new JSONObject(ansiStr);
        TrackBook track = new Gson().fromJson(object.toString(),TrackBook.class);
        List<String> trackList=track.getTraceback();
    } catch (JSONException e) {
        e.printStackTrace();
    }