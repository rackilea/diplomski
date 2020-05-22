public String toString() {
    StringBuilder sb = new StringBuilder();
    for (SelectedItem item : cartItems) {
        sb.append("Item: " + item.getDescription() + "\nQuantity: " + item.getQuantity() + "\nUnit Price: $" + item.getUnitPrice() + "\nTotal Price: $" + (item.getQuantity()*item.getUnitPrice()) + "\n\n");
    }
    return sb.toString();
}