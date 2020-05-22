public double distance(double x, double y, double x2, double y2) {
        // r is earth’s radius (mean radius = 6,371km)
        double r = 6371e3;
        double toMile = 0.000621371;
        double latDiff = (x2 - x)*(Math.PI)/180;
        double lonDiff = (y2 - y)*(Math.PI)/180;;

        // a is the square of half the chord length between the points
        double a = (Math.sin(latDiff/2) * Math.sin(latDiff/2)) + (Math.cos(x) * Math.cos(x2) * Math.sin(lonDiff/2) * Math.sin(lonDiff/2));

        // c is the angular distance in radians
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        // d is the distance between to points
        double d = r * c * toMile;

        return d;
    }