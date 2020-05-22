enum MerchantType {
  STOCKBROKER,
  FINANCIAL_ADVISER;

  private static final Map<MerchantType, Set<StockType>> STOCK_TYPES;

  static {
    STOCK_TYPES = new EnumSet<MerchantType, Set<StockType>>(MerchantType.class);
    STOCK_TYPES.put(STOCKBROKER, EnumSet.of(StockType.LISTED_EQUITIES));
    STOCK_TYPES.put(FINANCIAL_ADVISER,
      EnumSet.of(StockType.LISTED_EQUITIES, StockType.MANAGED_FUNDS));
  }

  public boolean canSell(StockType stockType) {
    Set<StockType> stockTypes = STOCK_TYPES.get(this);
    return stockTypes != null && stockTypes.contains(stockType);
  }
}