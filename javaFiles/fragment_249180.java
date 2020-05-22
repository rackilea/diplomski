class StockURLReader implements ItemReader<StockReader> {
  String[] tokens = new String[0];
  int index = 0;
  StockDAO stockReader;

  void setURL(String URL) {
    this.tokens = URL.split(",");
    index = 0;
  }

  StockData read() {
    if(index < tokens.length) {
      return stockReader.getStockData(tokens[index++]);
    }
    return null;
  }
}