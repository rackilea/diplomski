private Item getKey(ArrayList<Item> inventory) {
    for(Item item : inventory) {
        if(item.isKey()) {
            return item;
        }
    }
    return null;
}