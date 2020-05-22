private static double parseDouble(String s)
{
    double num;
    try
    {
        num = Double.parseDouble(num1Text.getText());
    } catch (NumberFormatException e)
    {
        // either use a default value or give feedback to the user on what he did wrong
        // for example
        num = 1;
    }

    return num;
}