public int getIndex(List<String> text, String target) {
    for (int i = 0; i < text.size(); i++) {
        if (text.get(i).startsWith(target)) {
            return i;
        }
    }
    return -1;
}