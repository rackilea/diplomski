ArrayList<Stock> stockList = new ArrayList<MainActivity.Stock>();
while(result.next()){
    Stock stock = new Stock();
    stock.number = result.getInt(1);
    stock.name = result.getString(2);
    stock.quantity = result.getInt(3);
    stock.unity = result.getString(4);
    stock.stockThreshold = result.getInt(5);
    stockList.add(stock);
    }