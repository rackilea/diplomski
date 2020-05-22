class ArrayComparator implements java.util.Comparator<Comparable[]>{
    private int col;
    public ArrayComparator(int col){
        this.col = col;
    }
    public int compare(Comparable[] o1, Comparable[] o2){
        return o1[col].compareTo(o2[col]);
    }
};