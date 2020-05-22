public class ProgressMonitoringComparator<T extends Comparable<T>> implements Comparator<T> {

    private static final boolean DEFAULT_SOFT = false;
    private static final int DEFAULT_ELEMENT_CNT = -1;
    private volatile long invocationCount = 0;
    private volatile boolean cancelled = false;
    private final long elementCount;
    private final ProgressMonitor monitor;
    private final Comparator<T> delegate;
    private final boolean soft;

    public boolean isCancelled() {

        return cancelled;
    }

    public void setCancelled(boolean cancelled) {

        this.cancelled = cancelled;
    }

    public double getProgress() {

        if(elementCount <= 0) {
            return -1;
        }
        long totalInvocationsNeeded = (long)(elementCount * Math.log(elementCount));
        return totalInvocationsNeeded / (double)invocationCount;
    }

    public ProgressMonitoringComparator(ProgressMonitor monitor, Comparator<T> delegate, boolean soft) {
        super();
        this.elementCount = DEFAULT_ELEMENT_CNT;
        this.monitor = monitor;
        this.delegate = delegate;
        this.soft = soft;
    }

    public ProgressMonitoringComparator(ProgressMonitor monitor, Comparator<T> delegate) {
        this(monitor, delegate, DEFAULT_SOFT);
    }

    public ProgressMonitoringComparator(ProgressMonitor monitor, boolean soft) {
        this(monitor, null, soft);
    }

    public ProgressMonitoringComparator(ProgressMonitor monitor) {
        this(monitor, DEFAULT_SOFT);
    }

    public ProgressMonitoringComparator(long elementCount, Comparator<T> delegate, boolean soft) {
        super();
        this.elementCount = elementCount;
        this.monitor = null;
        this.delegate = delegate;
        this.soft = soft;
    }

    public ProgressMonitoringComparator(long elementCount, boolean soft) {
        this(elementCount, null, soft);
    }

    public ProgressMonitoringComparator(long elementCount) {
        this(elementCount, DEFAULT_SOFT);
    }

    @Override
    public int compare(T o1, T o2) {

        if(cancelled || (monitor != null && monitor.isCancelled())) {
            if(soft) {
                return 0;
            }
            throw new CancelException();
        }
        invocationCount++;
        if(monitor != null) {
            monitor.worked();
        }
        if(delegate != null) {
            return delegate.compare(o1, o2);
        }
        return o1.compareTo(o2);
    }
}