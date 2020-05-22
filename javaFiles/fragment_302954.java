private static void removeTheFirstNameDuplicates(final Map<String, String> map) {
    final Iterator<Entry<String, String>> iter = map.entrySet().iterator();
    final HashSet<String> valueSet = new HashSet<String>();
    while (iter.hasNext()) {
        final Entry<String, String> next = iter.next();
        if (!valueSet.add(next.getValue())) {
            iter.remove();
        }
    }
}