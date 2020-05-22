public void add(StockUpdate newStockUpdate) {
  StockUpdate stockUpdate = findStockUpdateBySymbol(newStockUpdate.getStockSymbol());
  if (stockUpdate != null
      && stockUpdate.getPrice().equals(newStockUpdate.getPrice())) {
    return;
  }

  /* data.add mathod checks the new data against the existing data. If no change is found, the update is discarded. */
  this.data.add(0, newStockUpdate);
  notifyItemInserted(0);
}

// On non-android, it's easier to do this with a stream/findFirst.
private StockUpdate findStockUpdateBySymbol(StockSymbol sym) {
    for (StockUpdate stockUpdate : data) {
        if (stockUpdate.getStockSymbol().equals(sym)) {
            return stockUpdate;
        }
    }
    return null;
}