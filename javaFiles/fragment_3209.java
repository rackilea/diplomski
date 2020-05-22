int batchSize = 500;
List<Item> items = new ArrayList(batchSize);
for (Item item : asd) {
    items.add(item);
    if (items.size() >= batchSize) {
        //persist
    }
}