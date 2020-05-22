List keys = dataset.getKeys();
while (iterator.hasNext()) {
    Comparable current = (Comparable) iterator.next();
    Number value = dataset.getValue(current);
    …
}