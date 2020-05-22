// Returns how far you need to move in X and Y to get to where you're looking
// Rotation is in degrees, distance is how far you want to move
public static double PolarToCartesianX(double rotation, double distance) {
    return distance * Math.cos(rotation * (Math.PI / 180.0D));
}

public static double PolarToCartesianY(double rotation, double distance) {
    return distance * Math.sin(rotation * (Math.PI / 180.0D));
}