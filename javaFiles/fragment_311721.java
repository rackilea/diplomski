public void addItem(Item foodItem) {

    if (!items.contains(foodItem.getName())) {
      items.put(foodItem.getName(), foodItem);          
    }
    items.get(foodItem.getName()).incrementBuyerCount();
}