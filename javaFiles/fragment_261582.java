public class QueueWrapper<E> implements BlockingQueue<E> {
    private Queue<E> myQueue = new LinkedBlockingQueue<>();
    private Map<E, Status> statusMap;

    public QueueWrapper(Map<E, Status> statusMap) {
        this.statusMap = statusMap;
    }

    [...]
    @Override
    public E take() throws InterruptedException {
        E result = myQueue.take();
        statusMap.put(result, Status.AFTER_FIRST);
        return result;
    }