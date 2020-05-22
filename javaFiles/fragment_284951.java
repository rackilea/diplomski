/**
 * @param x any value
 * @return x within [0..2PI)
public static double transform(double x) {
    x = Math.abs(x);   // We can do this because Cosine is symmetric around the y axis.
    double y = Math.floor(x / (Math.PI * 2));
    return x - y * Math.PI * 2;
}