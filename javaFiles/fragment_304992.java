static String createString(TreeItem<String> item) {
    List<TreeItem<String>> hierarchy = new ArrayList<>();
    while (item != null) {
        hierarchy.add(item);
        item = item.getParent();
    }

    // list iterator positioned at the end of the list
    ListIterator<TreeItem<String>> iterator = hierarchy.listIterator(hierarchy.size());

    StringJoiner sj = new StringJoiner(" > ");

    // join Strings in reverse order
    while (iterator.hasPrevious()) {
        sj.add(iterator.previous().getValue());
    }
    return sj.toString();
}