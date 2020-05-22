Location loc1 = new Location("");
loc1.setLatitude(lat1);
loc1.setLongitude(lon1);

Location loc2 = new Location("");
loc2.setLatitude(lat2);
loc2.setLongitude(lon2);

float distance = loc1.distanceTo(loc2);

int speed=30;
float time = distance/speed;