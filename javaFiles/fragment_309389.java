addRequest(String product, int amount) {
  StockHolding holding = findInList(product, myList);
  if (holding == null) {
    myList.add(new StockHolding(product, amount));
  } else {
    holding.setQuantity(amount+holding.getQuantity());
  }