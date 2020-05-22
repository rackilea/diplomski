final String table = ...;
final int ctype = ...;
Callable<Void> myCommand = new Callable<Void>() {
    public Void call() {
        invokeCommand(table, ctype);
        return null;
    }
};