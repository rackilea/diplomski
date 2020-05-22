public double divide(double numerator, double denominator)
{
    if(denominator == 0)
    {
        System.out.println("Error cannot divide by 0");
        return 0.0;
    }
    else
    {
        return numerator / denominator;
    }
}