public class MyComparator implements Comparator<List<MyObject> {
    int columnToSortOn;
    public MyComparator(int columnToSortOn) {
        this.columnToSortOn = columnToSortOn;
    }
    @Override
    public int compare(List<MyObject> list1, List<MyObject> list2) {
        return list1.get(columnToSortOn).compareTo(list2.get(columnToSortOn));
    }
}