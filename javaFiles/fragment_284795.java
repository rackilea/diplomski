public class MyList<T> {

    List<T> myData = new ArrayList<>();

    public void add(T ob) {
        myData.add(ob);
    }

    public T getAtIndex(int ix) {
        return myData.get(ix);
    }
}