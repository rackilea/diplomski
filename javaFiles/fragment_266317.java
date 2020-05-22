private static int gcd(int number1, int... otherNumbers)
{
    int result = number1;
    for(int number: otherNumbers)
        result = gcd(result, number);
    return result;
}