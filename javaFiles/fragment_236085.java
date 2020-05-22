static boolean hasEvenLength(int n)
{
    if (n<2) { // single digit
        return false;
    }
    return !hasEvenLength(n/2);
}