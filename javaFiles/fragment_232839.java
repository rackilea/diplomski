public static final double a = 6378137;
public static final double f = 0.0034;
public static final double b = 6.3568e6;
public static final double e = Math.sqrt((Math.pow(a, 2) - Math.pow(b, 2)) / Math.pow(a, 2));
public static final double e2 = Math.sqrt((Math.pow(a, 2) - Math.pow(b, 2)) / Math.pow(b, 2));

public static double[] ecef2lla(double x, double y, double z) {

    double[] lla = { 0, 0, 0 };
    double lan, lon, height, N , theta, p;

    p = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

    theta = Math.atan((z * a) / (p * b));

    lon = Math.atan(y / x);

    lat = Math.atan(((z + Math.pow(e2, 2) * b * Math.pow(Math.sin(theta), 3)) / ((p - Math.pow(e, 2) * a * Math.pow(Math.cos(theta), 3)))));
    N = a / (Math.sqrt(1 - (Math.pow(e, 2) * Math.pow(Math.sin(lat), 2))));

    double m = (p / Math.cos(lat));
    height = m - N;


    lon = lon * 180 / Math.PI;
    lat = lat * 180 / Math.PI; 
    lla[0] = lat;
    lla[1] = lon;
    lla[2] = height;
    return lla;
}