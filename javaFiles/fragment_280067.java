public class Filter {

    // properties, constructors, getters, setters ...

    public Comparator<Item> itemComparator() {
        return (item1, item2) -> {
            Double val1 = (Double) PropertyUtils.getProperty(item1, fieldName);
            Double val2 = (Double) PropertyUtils.getProperty(item2, fieldName);
            return (order.equals("asc") ? val1.compareTo(val2) : val2.compareTo(val1);
        };
    }

    public static Comparator<Item> chainedItemComparators(List<Filter> filters) {
        return filters.stream()
            .map(Filter::itemComparator)
            .reduce((item1, item2) -> 0, (f1, f2) -> f1.thenComparing(f2));
    }
}