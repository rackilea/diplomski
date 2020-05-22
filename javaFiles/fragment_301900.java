private static class ComparatorCreator<T extends Comparable<? super T>>{
    public Comparator<? extends T> getComparator()
    {
        return T::compareTo;
    }
}