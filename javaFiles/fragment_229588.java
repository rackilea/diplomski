if(Objects.nonNull(stock.getStockDailyRecords())){
    stock.getStockDailyRecords().add(stockDailyRecords);
} else {
    Set setA = new HashSet();
    set.add(stockDailyRecords);
    stock.setStockDailyRecords(setA);
}