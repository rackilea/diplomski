/**
 * The observer
 */
public interface AsyncWorkDoneListener{

    /**
     * This method will be called when the async-thread is
     *  done.
     */
    public void done(Object unit);

}

/**
 * The worker (which does the asyc-work on another thread).
 */
public class AsyncWorker{

    private AsyncWorkDoneListener listener;

    /**
     * Set (you might want to maintain a list here) the current
     *  listener for this "AsyncWorker".
     */
    public void setListener(AsyncWorkDoneListener listener){
        this.listener = listener;
    }

    /**
     * Will do the async-work
     */
    public void doWork(){
        // Do the work in another thread...
        // When done, notify the registered listener with the
        //  result of the async work:
        this.listener.done(the_object_containing_the_result);
    }
}

/**
 * The application
 */
public class App implements AsyncWorkDoneListener{

    public void someMethod(){
        // Work on something asynchronously:
        mAsyncWorker.setListener(this);
        mAsyncWorker.doWork();
    }

    @Override
    public void done(Object unit){
        // The asyc work has finished, do something with
        //  the result in "unit".
    }
}