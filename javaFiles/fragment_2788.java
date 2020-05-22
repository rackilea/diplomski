String validateItemQuantity(String itemQuantity) {
    while (true) {
        try { 
            return Integer.parseInt(itemQuantity); // returns if no exception
        } catch (NumberFormatException e) {
           itemQuantity = JOptionPane.showInputDialog(
               "Invalid item quantiy, please enter a new Value"));
        }
    }
}