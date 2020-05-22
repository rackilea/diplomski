int getMostSignificantDigit(int x)
{
    // Need to handle Integer.MIN_VALUE "specially" as the absolute value can't
    // represented. We can hard-code the fact that it starts with 2 :)
    x = x == Integer.MIN_VALUE ? 2 : Math.abs(x);
    while (x >= 10)
    {
        x = x / 10;
    }
    return x;
}