int stringCompare(String a, String b)
{
    int sum = 0;
    for(int i = 0; i < a.length() && i < b.length(); i++)
        sum += a.charAt(i) - b.charAt(i);
    for(int i = b.length(); i < a.length(); i++)
        sum += a.charAt(i);
    for(int i = a.length(); i < b.length(); i++)
        sum -= b.charAt(i);
    return sum;
}