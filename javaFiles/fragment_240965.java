class ThreadTask implements Callable<Object> {

    public Object call() {
        // execute download
        ...
        return result;
    }
}