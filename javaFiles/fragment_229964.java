public class MyClass implements Runnable {
    private volatile boolean isAlive=true;

   /**
    * Request thread stop by calling requestThreadStop() externally.
    */
    public void requestThreadStop() {
        isAlive = false;
    }

    @Override
    public void run() {
        while(isAlive) {
            //Do All your thread work
            //if isAlive is modified, the next iteration will not happen
        }
    }
}