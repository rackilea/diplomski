public void add(Item item) {
    for (Item items : inventory) {
        if (items.getName().equalsIgnoreCase(item.getName())) {
            items = item;
        } else {
            inventory.add(item);
        }
    }
}