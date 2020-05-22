public static float numberOfIterationsToCheckSmooth(Complex z0, int max) {
    Complex z = z0;
    for (int t = 0; t < max; t++) {
        double fAbs = z.abs();
        if (fAbs > 2.0)
        {
             // based on the final value, add a fractional amount based on
             // how much it escaped by (fAbs will be in the range of 2 to around 4):                 
             return (float)t + (2.0f - (Math.log(fAbs) / Math.log(2.0)));
        }
        z =z.multiply(z).add(z0);
    }
    return (float)max;
}