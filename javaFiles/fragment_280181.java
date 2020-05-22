public void train(double[][] xs, double[] ys)
{
    if(xs.length != ys.length)
        return;
    if(xs.length == 0)
        return;

    int N = xs[0].length;

    // init coefficients
    if(coefficients == null)
        coefficients = new double[N];

    // start training
    double c0 = cost(xs, ys);
    for(int i=0;i<nofEpochs;i++)
    {
        // execute one epoch of training
        epoch(xs, ys);
        double c1 = cost(xs, ys);

        // quit if cost becomes higher
        if(c1 > c0)
            break;

        c0 = c1;

        // print debug output
        if(isDebugEnabled)
            System.out.println("epoch : " + i + "\tcost : " + c1);
    }

}