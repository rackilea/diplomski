public class MyList {

    List myData = new ArrayList();

    public void add(Object ob) {
        myData.add(ob);
    }

    public Object getAtIndex(int ix) {
        return myData.get(ix);
    }
}