/**
 * Causes this thread to begin execution; the Java Virtual Machine 
 * calls the <code>run</code> method of this thread. 
 * <p>
 * The result is that two threads are running concurrently: the 
 * current thread (which returns from the call to the 
 * <code>start</code> method) and the other thread (which executes its 
 * <code>run</code> method). 
 * ...
 */
public synchronized void start() {
   ...