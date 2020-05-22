public static double distance(double lat1, double lat2, double lng1,
    double lng2) {

final int R = 6371; // Radius of the earth

Double latDistance = Math.toRadians(lat2 - lat1);
Double lngDistance = Math.toRadians(lng2 - lng1);
Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
        + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
        * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
double distance = R * c; // convert to meters

return distance;