int index = 0;
for (String key : map.keySet()) {
    if (index++ < fromIndex || index++ > toIndex) {
        continue;
    }
    ...
}