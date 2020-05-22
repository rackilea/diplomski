while (it.hasNext()) {
    String key = it.next();
    list.add(key);
}
while (it.hasPrevious()) {
    String key = it.previous();
    list.remove(key);
}