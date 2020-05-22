// get from user input
String countryName =...
String itemName =...

// loop  through the items list we created
for (Item item : items) {
    if (item.getName().equalsIgnoreCase(itemName)) {
        // we found the item we are looking for! get the price
        double price = item.getPrice(countryName);
        // do what you want with this...
        System.out.println(itemName + "'s price in " + countryName + " is " + price + ".");
        // We are done looking - we found the item and got it's price. End the loop
        break;
    }
}