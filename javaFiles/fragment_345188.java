public static void main (String[] args) throws java.lang.Exception
{
    Pattern p= Pattern.compile("Transform\\s+for(.*)unavailable");
    String s = "Transform for c5d2f185503a11e68f4dd4bed9c2c707 unavailable";

    Matcher m = p.matcher(s);
    if ( m.find() )
    {
        System.out.println("Found match : " + m.group(1));

    }
}