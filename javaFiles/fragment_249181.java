class StockURLReader implements ItemReader<StockDataListBean> {
  String[] URLs = new String[0];
  int index;
  StockDAO stockReader;

  void setURLs(String[] URL) {
    this.URLs = URL;
    index = 0;
  }

  StockDataListBean read() {
    StockDataListBean item = null;
    if(index < URLs.length)
    {
      item = new StockDataListBean();
      for(String token : URLs[index].split(",").length)
      {
        item.data.add(stockReader.getStockData(token));
      }
    }
    return item;
  }
}