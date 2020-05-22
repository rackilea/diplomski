public InventoryItem itemWithLowestCost() {

  InventoryItem smallest = iList.get(0);

  int i = 1;
  while (i<iList.size()) {
    if(iList.get(i).getCost() < smallest.getCost()) {
      smallest = iList.get(i);
    }
    i++;
  }

  return smallest;
}