public static String interleave(String s, int interval, String separator)
{
    StringBuilder sb = new StringBuilder(s);
    for (int pos = (s.length()-1) / interval; pos > 0; pos--)
    {
        sb.insert(pos * interval, separator);
    }
    return sb.toString();
}