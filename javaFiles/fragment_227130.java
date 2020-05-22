private static MultivariateFunction createLogging(
    final MultivariateFunction delegate)
{
    return new MultivariateFunction()
    {
        @Override
        public double value(double[] point)
        {
            double result = delegate.value(point);
            System.out.println("Evaluated "+
                Arrays.toString(point)+" to "+result);
            return result;
        }
    };
}