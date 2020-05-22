if (text.length() == 16)
{
    if ((text.charAt(2) == '/' && text.charAt(5) == '/') ||
        (text.charAt(2) == '.' && text.charAt(5) == '.'))
    {
        text = text.substring(0, 2) + "-" + text.substring(3, 5) 
           + "-" + text.substring(6);
    }
}