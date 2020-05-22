public static <E> ListBubbleSort withList(List<E> list) {
    return new ListBubbleSort(list);
}

private ListBubbleSort(List<E>) {
    super(list);
}

protected ListSortierer(List<E>) {
    // initialise only the list field
    this.origin = list;
}