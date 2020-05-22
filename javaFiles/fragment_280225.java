int size = list.getValue().size();
if (size  == maxSize) {
    maxKeySet.add(list.getKey());
}
if (size  > maxSize) {
    maxKeySet.clear();
    maxKeySet.add(list.getKey());
    maxSize = size;
}