public static boolean getPhoneInput(String displayText)
{
    int count = 0;
    String input;
    input = JOptionPane.showInputDialog(displayText);
    String pattern = "\\d-(\\d{3})-(\\d{3})-(\\d{4})";
    Pattern p = Pattern.compile(pattern);
    while ((displayText != null && input.length() == 0))
    {
        input = JOptionPane.showInputDialog("No input was detected \n" + displayText);
        count++;
        if (count == 2)
        {
            JOptionPane.showMessageDialog(null, " Sorry due to errors your order cannot be processed.  GOODBYE.");
            System.exit(0);
        }
    }
    count = 0;
    while (count <= 3)
    {
        count++;
        Matcher m = p.matcher(input);
        if (m.matches())
            return true;
        else
            input = JOptionPane.showInputDialog("Input in wrong format. \n" + displayText);
    }
    return false;
}