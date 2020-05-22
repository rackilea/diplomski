int myCompareTo(String a, String b)
{
    int aLength = a.length(), bLength = b.length();
    int minLength = Math.min(aLength, bLength);

    for (int i = 0; i < minLength; i++)
    {
        if (a.charAt(i) > b.charAt(i)) return 1;    
        if (a.charAt(i) < b.charAt(i)) return -1;
    }

    if (aLength > bLength) return 1;
    if (aLength < bLength) return -1;
    return 0;
}