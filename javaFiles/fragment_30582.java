// calculate surface gravity static method
public static double[] surfaceGravity(double G, double[] M, double[] r){

    // equation for surface gravity
    double[] g = new double[M.length];

    for(int i=0;i<g.length;i++)
    {
        g[i] = (G * M[i]) / Math.pow(r[i], 2);
    }

    // return statement
    return g;
}