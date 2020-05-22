public class Collection {
    private ArrayList <Things> theCollection;

    public Collection () {
        theCollection = new ArrayList <> ();
    }

    public void get () {
        ...
        ListIterator <Things> listItr = theCollection.listIterator();
        sThing = listItr.next ();
        ...
    }
}