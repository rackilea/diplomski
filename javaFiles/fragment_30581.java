// calculate surface gravity static method
public static double surfaceGravity(double G, double[] M, double[] r){

    // equation for surface gravity
    double[] g = (G * M) / Math.pow(r, 2);

    // return statement
    return g;
}