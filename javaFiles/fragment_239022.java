/* Java thread status for tools,
 * initialized to indicate thread 'not yet started'
 */

private volatile int threadStatus = 0;

...

public synchronized void start() {
    /**
     * This method is not invoked for the main method thread or "system"
     * group threads created/set up by the VM. Any new functionality added
     * to this method in the future may have to also be added to the VM.
     *
     * A zero status value corresponds to state "NEW".
     */
    if (threadStatus != 0)
        throw new IllegalThreadStateException();
....

public State getState() {
    // get current thread state
    return sun.misc.VM.toThreadState(threadStatus);
}