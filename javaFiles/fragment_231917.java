// We don't know what the type of text is here... adjust appropriately.
public static String getTextOrDefault(TextBox text, String defaultValue)
{
    if (text == null)
    {
        return defaultValue;
    }
    String textValue = text.getText();
    return textValue != null ? text.getText() : defaultValue;
}