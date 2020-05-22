public static double getAngle(double vx, double vy) {
    return Math.toDegrees(Math.atan2(vy, vx));
}

public static double getVelocityWithAngle(double vx, double vy) {
    return Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2));
}

public static void angleVelocityToXYVelocity(double angle, double velocity) {
    double vx = Math.cos(Math.toRadians(angle)) * velocity;
    double vy = Math.sqrt(Math.pow(velocity, 2) - Math.pow(vx, 2));

    System.out.println("vx: " + vx + " vy: " + vy);
}