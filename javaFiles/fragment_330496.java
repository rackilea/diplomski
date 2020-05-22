public static InventoryItem addNewItem() {

    String name = JOptionPane.showInputDialog(null," Enter new product name."," by Marquis Watkins", JOptionPane.QUESTION_MESSAGE);
    String price = JOptionPane.showInputDialog(null," Enter product price." ," by Marquis  Watkins", JOptionPane.QUESTION_MESSAGE);
    String quantity = JOptionPane.showInputDialog(null,"Enter quantity of product."," by Marquis Watkins", JOptionPane.QUESTION_MESSAGE);

    return new InventoryItem(name, price, quantity);
}