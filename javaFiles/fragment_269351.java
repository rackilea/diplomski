future = new FutureTask<T>(callable) {
    @Override
    protected void done() {
        doneEDT();  // <-----
        setState(StateValue.DONE);
    }
};