// We don't know what the type of text is here... adjust appropriately.
public static String getTextOrDefault(TextBox text, String defaultValue)
{
    return text != null && text.getText() != null ? text.getText()
                                                  : defaultValue;
}