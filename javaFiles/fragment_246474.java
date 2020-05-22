List<String> strings = Arrays.asList(
        "deleteItem", "createitem", "exportitem", "deleteItems", "createItems"
        );
Comparator<String> comparator = new Comparator<String>() {
    @Override
    public int compare(final String o1, final String o2) {
        if (o1.contains("delete") && !o2.contains("delete")) {
            return 1;
        }else if (!o1.contains("delete") && o2.contains("delete")) {
            return -1;
        }
        return 0;
    }
};
Collections.sort(strings, comparator);
System.out.println(strings);