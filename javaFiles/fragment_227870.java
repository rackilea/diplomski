class CustomSorting<T> implements Comparator<T> {

    private List<T> orderList;

    public CustomSorting(T ... elements) {
        this.orderList = Arrays.asList(elements);
    }

    @Override
    public int compare(T a, T b) {
        return weight(a) - weight(b);
    }

    private int weight(T a) {
        int index = orderList.indexOf(a);
        return index >= 0 ? index : Integer.MAX_VALUE;
    }
}