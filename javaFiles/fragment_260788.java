public static void addItem(Item item) {
    boolean found = false;
    for (int i = 0; i < inv.size(); i++) {
        if (inv.get(i).getName().equals(item.getName())) {
            inv.get(i).addQuantity();
            // Remember that we already had the item in inventory
            found = true;
            break;
        }
    }
    if (!found) {
        // Item isn't in inventory yet: add it
        inv.add(item);
    }
    System.out.println("Item added: 1 " + item.getName());
}