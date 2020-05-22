String validateItemQuantity(String itemQuantity) {
   try { 
       return Integer.parseInt(itemQuantity); // returns if no exception
   } catch (NumberFormatException e) {
       return validateItemQuantity(JOptionPane.showInputDialog 
                               ("Invalid item quantiy, please enter a new Value"));
   }
}