void buy(int n, Collection<T> items) {

    for (T e : stock.subList(0, n)) {
        items.add(e);
    }
    for (int i=0; i<n; ++i) stock.remove(0);

}