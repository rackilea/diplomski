public static int returnIndex(int n)
{
    String a = "ABCDE";
    n = Math.abs(n) % a.length();
    return a.length() - n;
}