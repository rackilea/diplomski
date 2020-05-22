/**
 * @param lat1
 * Latitude which was given by the device's internal GPS or Network location provider of the users location
 * @param lng1
 * Longitude which was given by the device's internal GPS or Network location provider of the users location 
 * @param lat2
 * Latitude of the object in which the user wants to know the distance they are from
 * @param lng2
 * Longitude of the object in which the user wants to know the distance they are from
 * @return
 * Distance from which the user is located from the specified target
*/
public static double distFrom(double lat1, double lng1, double lat2, double lng2) {
    double earthRadius = 3958.75;
    double dLat = Math.toRadians(lat2-lat1);
    double dLng = Math.toRadians(lng2-lng1);
    double sindLat = Math.sin(dLat / 2);
    double sindLng = Math.sin(dLng / 2);
    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(lat1) * Math.cos(lat2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    double dist = earthRadius * c;

    return dist;
}