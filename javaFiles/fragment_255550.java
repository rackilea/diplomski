List<MyItem> mapItems(ExternalResult externalResult) {
    return externalResult.getItems()
        .stream()
        .map(i -> new MyItem(i.getName())
        .collect(Collectors.toList());
}