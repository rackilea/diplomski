class Item {
    public int id;
    public float price;
}

ArrayList<Item> cart = new ArrayList<Item>(0);

do {

    Item item = new Item();

    item.id = userInput;
    item.price = userInput;

    cart.add(item);

} while (userInputting);

float total = 0;

for (Item i : cart) {
    total += i.price;
}

// using a regular for loop instead of for-each

for (int i = 0; i < cart.size(); i++) {
    Item item = cart.get(i);

    // or search for something particular

    if (item.id == searchID) {
        System.out.println("found item " + item.id + " with price $" + item.price);
    }

    // equivalent to

    if (ids[i] == searchID) {
        System.out.println("found item " + ids[i] + " with price $" + prices[i]);
    }
}