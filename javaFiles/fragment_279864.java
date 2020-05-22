location.setLatitude(latitude);
location.setLongitude(longitude);
location.setBearing(bearing);
location.setSpeed(speed);
location.setAltitude(altitude);
location.setTime(new Date().getTime());
location.setProvider(LocationManager.GPS_PROVIDER);
location.setAccuracy(1);