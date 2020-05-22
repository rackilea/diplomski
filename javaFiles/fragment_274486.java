public void addItem(String itemName, int quantity, Double price) {

    Item entry = currentOrderTable.getItems().stream()
        .filter(item -> item.getItem().equals(itemName))
        .findAny()
        .orElseGet(()-> {
             Item newItem = new Item(itemName, 0, 0);
             currentOrderTable.getItems().add(newItem);
             return newItem ;
        });

    entry.setQuantity(entry.getQuantity() + quantity)
    entry.setPrice(entry.getPrice() + price);


}