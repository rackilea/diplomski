double result = aprox(n);
double current = result;
while ((current * current) - n != 0)
{
    double nextapproximation = (n / current + current) / 2;

    // Stop infinite loop
    if (nextapproximation == current)
    {
        break;
    }
    current = nextapproximation;
    System.out.println(current);
}
System.out.println("Result: " + current);