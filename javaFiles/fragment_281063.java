public class ColValueIterator implements Iterator<ColValue> {
    private List<HColumn<ColName, ColValue>> backingList;
    //constructor taking List<...>
    int currentIndex = 0;
    public ColValue next() {
        return backingList.get(currentIndex++).getColumn();
    }
    //hasNext() implemented by comparing the currentIndex to backingList.size();
    //remove() may throw UnsupportedOperationException(), 
    //or you can remove the current element
}