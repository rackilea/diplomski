System.out.println("\nEnter item's price");
    Scanner newItemPriceSC = new Scanner(System.in);

    while (true) {
        System.out.println("Please type \"no more\" if there are no more items");
        String answ = newItemPriceSC.nextLine();
        if (!answ.equalsIgnoreCase("no more")) {
            System.out.println(answ.matches("\\d*") ? "Item price: " + answ : "Please enter a numerical value");
        } else {
            break;
        }
    }