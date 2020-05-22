private final AtomicReference<List<String>> listRef = new AtomicReference<>();
...
while (true) {
    List<String> currentList = listRef.get();
    List<String> newList = new ArrayList<String>(currentList);
    newList.add(stringToAdd);
    // if we update the list reference, make sure we don't overwrite another one
    if (listRef.compareAndSet(currentList, newList))
        break;
}