for (int i = 0; i < size(); i++) {
    if (item.compareTo(get(i)) < 0) {
        add(i, item);
        return;
    }
}
add(item);