ArrayList<Item> catalog = new ArrayList<Item>(0);

for (int i = 0; i < numItems; i++) {
    catalog.add(new Item(arg, arg, arg...));
}

// or

catalog.add(new PinkCurtains());
catalog.add(new FuzzyTowel());

for (Item item : catalog) {
    if (chosenItem == item.sku) {
        // do all your stuff
    }
}