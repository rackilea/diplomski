public void addItem(SelectedItem newItem) {
    boolean found = false;
    if (cartItems != null && !cartItems.isEmpty()) {
       for (SelectedItem item : cartItems) {
           if (newItem.getItemNumber() == item.getItemNumber()) {
               found = true;
           } 
       }
    } 
    if (found) {
        totalQuantity += newItem.getQuantity();
    } else {
        totalQuantity = newItem.getQuantity();
        cartItems.add(new SelectedItem(newItem.getItemNumber(), newItem.getDescription(),newItem.getUnitPrice(), newItem.getQuantity()));
    }
}