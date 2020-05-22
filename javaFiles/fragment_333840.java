private List<Map.Entry<String, LatLng>> getSearchResults() {
    List<Map.Entry<String, LatLng>> results = new ArrayList<>();
      for (Map.Entry<String, LatLng> entry : city.entrySet()) {
        if (entry.getKey().toLowerCase().startsWith(text.getText().toString().toLowerCase())) {
            results.add(entry);
        }
      }
    return results;
    }