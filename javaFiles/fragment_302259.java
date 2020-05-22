double[] derivs(double xin, double yin[])
{
    double dydx[] = new double[N];
    /* function to fill array of derivatives dydx at xin */

    dydx[0] = yin[1]; 
    dydx[1] = -g/L1*Math.sin(yin[0]);
    /*        Error was here ^^^^^^^     */

    return dydx;
}