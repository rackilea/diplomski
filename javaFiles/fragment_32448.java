enum MerchantType {
  STOCKBROKER(StockType.LISTED_EQUITIES),
  FINANCIAL_ADVISER(StockType.MANAGED_FUNDS);

  private final StockType stockType;

  MerchantType(StockType stockType) {
    this.stockType = stockType;
  }

  public StockType getStockType() {
    return stockType;
  }
}