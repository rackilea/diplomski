public int compare(MyBean o1, MyBean o2) {
    if (o1.getDate() == null) {
        return (o2.getDate() == null) ? 0 : -1;
    }
    if (o2.getDate() == null) {
        return 1;
    }
    return o2.getDate().compareTo(o1.getDate());
}