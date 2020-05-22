import javax.swing.SwingUtilities;

/** Check methods / classes marked as WorkerThreadOnly or EventDispatchThreadOnly */
public aspect ThreadChecking {

    /** you can adjust selection to a subset of methods / classes */
    pointcut selection() : execution (* *(..));

    pointcut edt() : selection() && 
        (within (@EventDispatchThreadOnly *) ||
        @annotation(EventDispatchThreadOnly));

    pointcut worker() : selection() && 
        (within (@WorkerThreadOnly *) ||
        @annotation(WorkerThreadOnly));

    before(): edt() {
        assert (SwingUtilities.isEventDispatchThread());
    }

    before(): worker() {
        assert (!SwingUtilities.isEventDispatchThread());
    }
}