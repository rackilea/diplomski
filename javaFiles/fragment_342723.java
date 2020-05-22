long t1 = location1.getTimeStamp(); // in milliseconds;
long t2 = location2.getTimeStamp();
double deltaLat = location2.latitude - location1.latitude;
doule deltaLon =  location2.longitude- location1.longtude;
// remove this line if you don't have measured speed:
double deltaSpeed =  location2.speed - location1.speed;

long step = 1 * 1000; // 1 second in millis 
for (long t = t1; t1 < t2; t+= step) {

   // t0_1 shall run from 0.0 to (nearly) 1.0 in that loop
  double t0_1 = (t - t1) / (t2 - t1);
  double latInter = lat1 + deltaLat  * t0_1;
  double lonInter = lon1 + deltaLon  * t0_1;
  // remove the line below if you dont have speed
  double speedInter = speed1 + deltaSpeed  * t0_1;
  Location interPolLocation = new Location(latInter, lonInter, speedInter);
  // add interPolLocation to list or plot.
}