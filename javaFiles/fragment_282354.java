Iterator iterator = collection.iterator();
while (iterator.hasNext()) {
    Item item = (Item) iterator.next();
    if (item.satisfiesCondition()) {
       collection.remove(item);
    }
}