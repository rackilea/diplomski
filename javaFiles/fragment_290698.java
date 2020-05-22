public class InputOutput {
    public int displayMenu()
    {

        String stringChoice = JOptionPane.showInputDialog("Restaurant:\n"
                + "1. Pancakes: $10.00\n"
                + "2. Bananas: $1.00\n"
                + "3. Bread: $2.00\n");
        if (numberValidator.isNumeric(stringChoice)){
            choiceNumber = Integer.parseInt(stringChoice);   
        }
        else {
            return displayMenu();
            }
        return choiceNumber;
    }