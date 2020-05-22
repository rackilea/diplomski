public static boolean doubleEquals(double val1, double val2, double epsilon)
{
    return Math.abs(val1 - val2) < epsilon;
}

public static boolean doubleEquals(double val1, double val2)
{
    return doubleEquals(val1, val2, 1e-5);
}