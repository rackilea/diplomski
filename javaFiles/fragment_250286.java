class MyList<T> implements StudentList<T> {
    private ArrayList<T> realList;

    public MyList() {
        realList = new ArrayList<T>();
    }

    public void add(T element) {
        realList.add(element);
    }

    .......
}