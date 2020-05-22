public void addItem(String name, double cost, int quantity) {
    if (counter == list.length) {
        System.out.println("Your cart is full! No more items can be added.");
        return;
    }
    list[counter] = new GroceryItemOrder(name, cost, quantity);
    counter++;
}