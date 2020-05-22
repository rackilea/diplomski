List<Item> listItem = new ArrayList<Item>();
boolean orderNotFinished = true;
while (orderNotFinished) {
    System.out.println("Please Choose an Item From Menu List");
    input = new Scanner(System.in);
    String itemChosen = input.nextLine();
    boolean insertedMenuItemId = db.goTodataBase.checkMenuItemInDB(itemChosen);
    if (insertedMenuItemId) {
        System.out.println("You Choose Item ID: " + itemChosen);
        listItem.add(Item.getItemByName(itemChosen)); //Add the chosen item to the list
        System.out.print("You want something else ? ");
        String hasFinished = input.nextLine();
        orderNotFinished = hasFinished.equals("yes");
    }else {
        System.out.println("Item Chosen doen't exist");
    }
}