for(Place place: places){
    JSONObject obj = new JSONObject();
    obj.put("lat",place.getContactData().getLatitude());
    obj.put("lng",place.getContactData().getLongitude());
    locations.put(obj);
}