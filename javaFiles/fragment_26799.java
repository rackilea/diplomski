private static String findLastDecimal(String string)
{
    Matcher m = Pattern.compile("(\\d+\\.\\d+)(?!.*\\d+\\.\\d+)").matcher(string);
    if (m.find())
    {
        return m.group(1);
    }
    return null;
}