public static double gauss(double x) 
{
    x = -x*x;
    double exp = 0, error = 1, numerator = 1, denominator = 1;
    double machineEpsilon = 1.0;
    // calculate machineEpsilon
    while ((1.0 + 0.5 * machineEpsilon) != 1.0)
        machineEpsilon = 0.5 * machineEpsilon;
    int n = 0; //
    // while the error is large enough to be representable in terms of the current data type
    while ((error >= machineEpsilon) || (-error <= -machineEpsilon))
    {
        exp += error;
        // calculate the numerator (it is 1 if we just start, but -x times its past value otherwise)
        numerator = ((n == 0) ? 1 : -numerator * x);
        // calculate the denominator (denominator gets multiplied by n)
        denominator *= (n++);
        // calculate error
        error = numerator/denominator;
    }
    return exp;
}