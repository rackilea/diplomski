public static void removeItem(Item item) {
    for (int i = 0; i < inv.size(); i++) {
        if (inv.get(i).getName().equals(item.getName())) {
            // Reduce quantity
            inv.get(i).minusQuantity();
            if (inv.get(i).getQuantity() == 0) {
                // We don't have any quantity left: remove item from inventory
                inv.remove(item);
            }
            break;
        }
    }
}