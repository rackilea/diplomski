arrayToStoreTheDigits = new int[digits.length()];
for (int i = 0; i < arrayToStoreTheDigits.length; i++)
{
    // TODO: Digit validation
    arrayToStoreTheDigits[i] = digits.charAt(i) - '0';
}