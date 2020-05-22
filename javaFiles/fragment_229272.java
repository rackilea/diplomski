JComboBox<String> box = new JComboBox<>(StockData.getStock()
    .values()
    .stream()
    .map(StockData.Item::getName)
    .toArray(String[]::new)
);