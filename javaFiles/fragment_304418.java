boolean validateItemquantity() {
    try{ 
        Integer.parseInt(itemQuantityinput.getText());
        return true; 
    }
    catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Item quantity must be a positive number, please reenter");
        error = false; 
    }
}