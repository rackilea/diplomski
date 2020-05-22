public String getString(String input)
{
    if(input.matches(".*/.*/0.*"))
    {
        String yourString = input.substring(input.indexOf("/")+1);
        yourString = yourString.substring(0, yourString.indexOf("/"));
        return yourString;
    }
    else
    {
        String yourString = input.substring(input.indexOf("/")+1);
        yourString = yourString.substring(0, yourString.indexOf("/")+2);
        return yourString;
    }
}