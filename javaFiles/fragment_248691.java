public static double average(double[] grades)
{
    // Error check up front.
    if (grades.length == 0) { 
        throw new InvalidArgumentException("length is 0");
    }

    // These next lines are good.
    double total = 0;
    for (double i : grades)
    {
        total += i;
    }

    // Then you can just divide and return.
    return total / (grades.length);
}