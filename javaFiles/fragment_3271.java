public class OnlineStore {

    // public static void main(String[] args) // main program

    public int display_menu() // Not the main program but the main menu.
    {
        String main_selection;

        main_selection = JOptionPane.showInputDialog("Welcome!\n\n1. Add T-                Shirt Order\n2. Edit T-Shirt Order\n3. View Current Order\n4. Checkout\n\nPlease   enter your choice: ");
        return Integer.parseInt(main_selection);

    }

    public OnlineStore() // Switch-case program
    {
        switch (display_menu()) {
            case 1:
                JOptionPane.showMessageDialog(null, "Option 1");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Option 2");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Option 3");
                break;
            case 4:  // Deliberately not including a default selection.
                JOptionPane.showMessageDialog(null, "Option 4");
                break;
        }

    }

    public static void main(String[] args) // main program
    {
        new OnlineStore(); // Call out the program.
    }
}