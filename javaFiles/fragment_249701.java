public static class EventActionRule extends ForwardingTable<Source, Event, Action> {

    private Table<Source, Event, Action> delegate = HashBasedTable.create();

    @Override
    protected Table<Source, Event, Action> delegate() {
        return delegate;
    }

    // just an example: isEmpty (and other methods) is ready to be overriden
    @Override
    public boolean isEmpty() {
        boolean isEmpty = delegate().isEmpty();
        System.out.println("Was map empty? " + isEmpty);
        return isEmpty;
    }
}