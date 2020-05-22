public class Thread implements Runnable {
....
....

/* What will be run. */
private Runnable target;       // <-- Runnable is defined here for the thread.


public Thread(Runnable target) {  //<-- constructor you are calling.
    init(null, target, "Thread-" + nextThreadNum(), 0); //<-- internal init call.
}

private void init(ThreadGroup g, Runnable target, String name,
                  long stackSize) {
    init(g, target, name, stackSize, null);  //<-- internal init call.
}

private void init(ThreadGroup g, Runnable target, String name,
                  long stackSize, AccessControlContext acc) {
.....
.....
this.target = target;     // <-- Set the Runnable for the thread.
.....
}
....
....
}