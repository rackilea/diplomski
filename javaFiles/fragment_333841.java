search.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        List<Map.Entry<String, LatLng>> results = getSearchResults();
        if (results.size() > 0) {
            // in this case we have at least 1 result, so go to it
            set(mMap, results.get(0).getValue());
        } else {
            // in this case we have no results - handle it as you want
        }
    });