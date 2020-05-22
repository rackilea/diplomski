FilePool files = AutoEcon.files();
final MFilePrices prices = files.getPrices();
final MFilePrices intangibles = files.getIntangibles();
final MFilePrices groups = files.getGroups();
sellPrices.forEach((price, value) -> {
    if (EconItem.fromString(price) != null) {
        setPriceAndBuyRate(prices, price, value);
    } else if (intangibles.getLabels().contains(price)) {
        setPriceAndBuyRate(intangibles, price, value);
    } else if (groups.getLabels().contains(price)) {
        setPriceAndBuyRate(groups, price, value);
    }
});

private void setPriceAndBuyRate(MFilePrices filePrices, Price price, Value value) {
    filePrices.setPrice(price, value.getExpression());
    filePrices.setBuyRate(price, value.getBuyRate());
}