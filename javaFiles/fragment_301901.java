private static class ComparatorCreator<T extends Comparable<? super T>>{
    public Comparator<? extends T> getComparator()
    {
        return (o1, o2) -> {
            return o1.compareTo(o2);
        };
    }
}