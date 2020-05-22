public static class ComparatorFoo implements Comparator<Foo> {
    @Override
    public int compare(Foo o1, Foo o2) {
        if (o1.x < o2.x)
            return -1;
        else if (o1.x > o2.x)
            return 1;
        return 0;
    }
}