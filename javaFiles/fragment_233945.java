public static String randomDigits(Random random, int length)
{
    char[] digits = new char[length];
    // Make sure the leading digit isn't 0.
    digits[0] = (char)('1' + random.nextInt(9);
    for (int i = 1; i < length; i++)
    {
        digits[i] = (char)('0' + random.nextInt(10));
    }
    return new String(digits);
}