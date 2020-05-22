// similar to implementation of DistanceUtils.getBoundary():
double milesPerLng = DistanceApproximation.getMilesPerLngDeg(lat);
double milesPerLat = DistanceApproximation.getMilesperLatDeg();


double lngDelta = radius / milesPerLng;
double latDelta = radius / milesPerLat;

// Now it seems like this should be roughly true:
assertEquals(radius, DistanceUtils.getInstance().getDistanceMi(lat,lng,lat,lng+lngDelta));
assertEquals(radius, DistanceUtils.getInstance().getDistanceMi(lat,lng,lat+latDelta,lng));