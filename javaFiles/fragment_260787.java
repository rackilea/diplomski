public static void addItem(Item item) {
    for (int i = 0; i < inv.size(); i++) {
        if (inv.get(i).getName().equals(item.getName())) {
            inv.get(i).addQuantity();
        }
        break;
    }
    System.out.println("Item added: 1 " + item.getName());
}