public int getIndex(Iterable<String> elements, String target) {
    int index = 0;
    for (String element : elements) {
        if (element.startsWith(target)) {
            return index;
        }
        index++;
    }
    return -1;
}