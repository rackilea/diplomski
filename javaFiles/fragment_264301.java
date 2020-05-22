List<Data> results = new ArrayList<>();
for(Item item: items) {
    Data data = requestDataForItem(item);
    if(!data.isValid()) break;
    results.add(data);
}