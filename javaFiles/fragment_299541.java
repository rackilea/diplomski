// Based on the Gaussian class from Apache Commons Math
public static double gaussian(double x, double mean, double sigma)
{
    double norm = 1 / (sigma * Math.sqrt(2 * Math.PI));
    double  is = 1 / sigma;
    double i2s2 = 0.5 * is * is;
    double xMinusMean = x - mean;
    return norm * Math.exp(-xMinusMean * xMinusMean * i2s2);
}