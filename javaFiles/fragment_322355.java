Iterator<BuyOrderType> iter = market.buyOrders() // replace BuyOrderType with correct type here
            .stream()
            .filter(buyOrder -> buyOrder.price >= sellOrder.price)
            .sorted(BY_ASCENDING_PRICE).iterator();
while (iter.hasNext()) {
    BuyOrderType buyOrder = iter.next()  // replace BuyOrderType with correct type here
    double tradeVolume = Math.min(buyOrder.quantity, sellOrder.quantity);
    double price = buyOrder.price;

    buyOrder.quantity -= tradeVolume;
    sellOrder.quantity -= tradeVolume;

    Trade trade = new Trade.Builder(market, price, tradeVolume, Trade.Type.SELL).build();
    CommonUtil.convertToJSON(trade);

    if (sellOrder.quantity == 0) {
        System.out.println("order fulfilled");
        break;
    }
}