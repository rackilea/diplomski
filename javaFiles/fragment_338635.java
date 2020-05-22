Runnable callback = new Runnable() {
    public void run() {
       citymap.put("Chicago", new City(LatLng.create(41.878113, -87.629798), 2842518L));
       citymap.put("New York", new City(LatLng.create(40.714352, -74.005973), 8143197L));
       citymap.put("Los Angeles", new City(LatLng.create(34.052234, -118.243684), 3844829L));

       renderMap();
    }
};