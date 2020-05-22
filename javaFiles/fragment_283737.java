public static int equalsCount(String source)
{
    int count = 0;
    Matcher m = Pattern.compile("^(=+)?.+[^=](=+)?$").matcher(source);
    if (m.find())
    {
        count += m.group(1) == null ? 0 : m.group(1).length();
        count += m.group(2) == null ? 0 : m.group(2).length();
    }

    return count;
}

public static void main(String[] args)
{
    System.out.println(equalsCount("===Some=tex=t="));
    System.out.println(equalsCount("===Some=tex=t"));
    System.out.println(equalsCount("Some=tex=t="));
    System.out.println(equalsCount("Some=tex=t"));
}