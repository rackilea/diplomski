Location location1 = new Location("first location");    
location1.setLatitude(latitude1);
location1.setLongitude(longtitude1);

Location location2 = new Location("second location");
location2.setLatitude(latitude2);
location2.setLongitude(longtitude2);

float distanceBetween = location1.distanceTo(location2);