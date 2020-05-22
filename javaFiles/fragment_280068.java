public static void main(String[] args) {
    List<Filter> filters = new ArrayList<>(Arrays.asList(
        new Filter("price", "desc"),
        new Filter("size", "asc")
    ));
    List<Item> items = new ArrayList<>(Arrays.asList(
        new Item("bar", 6.0, 15.0),
        new Item("baz", 7.0, 5.0),
        new Item("foo", 10.0, 5.0)
    ));
    items.sort(Filter.chainedItemComparators(filters));
}