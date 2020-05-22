double r = Math.hypot(radarX, radarY);
double theta = Math.atan2(radarY, radarX);
theta -= Math.toRadians(Config.RADAR_FACING_DIRECTION);
float x = (float) r * Math.cos(theta);
float y = (float) r * Math.sin(theta);
longitude = metersToLongitude(Config.RADAR_POSITION, y) + Config.RADAR_POSITION.longitude;
latitude = metersToLatitude(Config.RADAR_POSITION, x) + Config.RADAR_POSITION.latitude;