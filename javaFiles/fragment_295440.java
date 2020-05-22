runOnUiThread(new Runnable() {
    @Override public void run() {
        adapter.add(new Location(R.drawable.ic_launcher, 
                json.getString("PlaceTitle"), 
                json.getString("PlaceDetails"), 
                json.getString("PlaceDistance"), "9-6"));
    }
});