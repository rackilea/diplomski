public static void printInventory(Item[] hardware) {
    System.out.printf("%-10s  %-20s  %-10s  %-10s%n",
            "itemID",
            "itemName",
            "inStore",
            "price"
    );

    System.out.println("--------------------------------------------------------");

    for (Item print : hardware) {
        System.out.printf("%-10s  %-20s  %-10s  $%,.2f%n",
                print.getItemID(),
                print.getItemName(),
                print.getInStore(),
                print.getPrice()
        );
    }
}