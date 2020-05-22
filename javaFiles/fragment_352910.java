class MyFutureTask extends FutureTask<Integer> {
    final IFormatter theCallable;

    public MyFutureTask(IFormatter callable) {
        super(callable);
        theCallable=callable;
    }
    Long getOrderId() {
        return theCallable.getOrderId();
    }
}