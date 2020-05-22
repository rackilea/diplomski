//utility function for userInput----------------
static private String showInputDialog()
{
    String inputValue = null;

    do {
        inputValue = JOptionPane.showInputDialog("Please input something");
    }
    while (inputValue != null && (inputValue.isEmpty() || !inputValue.matches("[A-Za-z]*")));

    return inputValue;
}