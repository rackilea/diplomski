public static void removeItem(Item item) {
    for (int i = 0; i < inv.size(); i++) {
        if ((inv.get(i).getName()).equals(item.getName())) {
            if ((inv.get(i).getQuantity()) == 0) {
                inv.remove(item);
            }
            else inv.get(i).minusQuantity();
        }
        break;
    }
}