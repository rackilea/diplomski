public int Multiply(int x, int y)
{
    if (x < 0) throw new ArgumentException("must be positive integer", "x");
    if (y < 0) throw new ArgumentException("must be positive integer", "y");

    if (x == 0 || y == 0) return 0; // obvious quick-exit condition

    // integer division
    int xDivBy10 = x / 10;
    int yDivBy10 = y / 10;

    bool xIsSingleDigit = xDivBy10 == 0;
    bool yIsSingleDigit = yDivBy10 == 0;

    // base case
    if (xIsSingleDigit && yIsSingleDigit)
    {
        return MultiplySingleDigits(x, y);
    }

    // otherwise, use grid multiplication recursively
    // http://en.wikipedia.org/wiki/Grid_method_multiplication

    if (xIsSingleDigit) // y must not be a single digit
    {
        return (Multiply(x, yDivBy10) * 10) + Multiply(x, y % 10);
    }

    if (yIsSingleDigit) // x must not be a single digit
    {
        return (Multiply(xDivBy10, y) * 10) + Multiply(x % 10, y);
    }

    // else - x and y are both numbers which are not single digits
    return (Multiply(x, yDivBy10) * 10) + Multiply(x, y % 10); // the same code as the "if (xIsSingleDigit)" case
}

// technically, this algorith can multiply any positive integers
// but I have restricted it to only single digits as per the assignment's requirements/hint
private int MultiplySingleDigits(int x, int y)
{
    if (x < 0 || x > 9) throw new ArgumentException("must be in range 0 - 9 (inclusive)", "x");
    if (y < 0 || y > 9) throw new ArgumentException("must be in range 0 - 9 (inclusive)", "y");

    if (x == 0 || y == 0) return 0; // base case
    return x + MultiplySingleDigits(x, y - 1);
}