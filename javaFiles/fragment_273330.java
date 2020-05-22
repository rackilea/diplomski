public class MyIterator implements Iterator {
    private Iterator wrappedIterator;

    public MyIterator( Iterator it ) {
        wrappedIterator = it;
    }

    public void remove( blabla ) {
        //do nothing or raise an error, whatever floats your boat
    }

    public void otherIteratorMethod() {
        wrappedIterator.otherIteratorMethod();
    }
 }