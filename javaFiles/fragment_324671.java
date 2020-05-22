public static Color decode(Display display, String hexString)
{
    try
    {
        java.awt.Color c = java.awt.Color.decode(hexString);

        return new Color(display, c.getRed(), c.getGreen(), c.getBlue());
    }
    catch(NumberFormatException e)
    {
        return null;
    }
}