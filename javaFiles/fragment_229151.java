interface EvenIterator {
    public boolean hasNext();
}


public class DataStructure {
    // ...

    private class InnerEvenIterator implements EvenIterator{
        // ...

        public boolean hasNext() { // Why public?
            // ...
        }
    }

    InnerEvenIterator iterator;

    public EvenIterator getIterator(){
         return iterator;
    }     

}