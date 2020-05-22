private double costDerivative(double[] x, double y, double[] cfs, int i)
{
    double delta = 0.00001;

    cfs[i] -= delta;
    double c0 = cost(x, y, cfs);

    cfs[i] += (delta * 2.0);
    double c1 = cost(x, y, cfs);

    return (c1 - c0) / (delta * 2.0);
}