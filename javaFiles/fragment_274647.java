double angleofapproach = toRad(scan.nextDouble());
double approachPath = (alt / Math.tan(angleofapproach));

// deg to rad
public static double toRad(double deg) {
    return deg * (Math.PI / 180);
}