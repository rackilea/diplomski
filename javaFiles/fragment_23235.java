public Iterable<Object> cellIterator() {
    final List<Object> items = new java.util.ArrayList<Object>();
    for(final List<Object> row : cells) {
        for(final Object cell: row) {
            items.add(cell);
        }
    }
    return items;
}