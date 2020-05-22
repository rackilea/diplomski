public InventoryItem itemWithLowestCost() {

  InventoryItem smallest = iList.get(0);

  for (int i=1;i<iList.size();i++) {
    if(iList.get(i).getCost() < smallest.getCost()) {
      smallest = iList.get(i);
    }
  }

  return smallest;
}