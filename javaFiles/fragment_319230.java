public class SortableList implements List<Object>, Comparable<SortableList> {
    private ArrayList delegate;

    public SortableList(List list) {
        delegate = new ArrayList(list);
    }

    @Override
    public int compareTo(SortableList s) {
        //Do what you need to do with your casts and comparisons
        return 0;
    }

    //And implement all the other methods in List by simply delegating to the ArrayList member variable
}