String maxKey;
int maxSize = -1;

for (Entry<String, List<String>> list: map.entrySet()) {
    int size = list.getValue().size();
    if (size  > maxSize) {
        maxKey = list.getKey();
        maxSize = size;
    }
}