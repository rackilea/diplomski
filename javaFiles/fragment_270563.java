public class TaskImpl<E> extends Task<Void> {
    private final List<E> list;

    public TaskImpl(List<E> list) { this.list = list; }

    @Override protected Void call() throws Exception {
        list.sort(null);
        return null;
    }
}