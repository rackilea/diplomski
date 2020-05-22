class Location {
  private double latitude;
  private double longitude;
  public Location(double latitude, double longitude) { ....}
}

private List<Location> getServerData(String returnString) {
 List<Location> result = new ArrayList<Location>();
 JSONArray jArray = new JSONArray(result);
 for(int i=0;i<jArray.length();i++){
    Location loc = new Location(json_data.getDouble("latitude"), json_data.getDouble("longitude"));
    result.add(loc);
 }
 return result;
}