private void epoch(double[][] xs, double[] ys)
{
    int N = xs.length;
    int M = xs[0].length;

    // calculate gradient
    double[] gradient = new double[M];
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<M;j++)
            gradient[j] += costDerivative(xs[i], ys[i], coefficients,j);
    }

    // normalize
    for(int i=0;i<M;i++)
    {
        gradient[i] /= N;
    }

    // apply
    for(int i=0;i<M;i++)
    {
        coefficients[i] -= (gradient[i] * learningRate);
    }
}