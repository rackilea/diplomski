public static void main(String[] args)
{
    String text = ""; // string was too long to fit here for tidiness
    Matcher search = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(text);
    while (search.find())
    {
        double doub = Double.parseDouble(search.group(1));
        if (doub mod 1 != 0)
        {
            System.out.println(doub);
        }
    }
}