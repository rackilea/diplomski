private final SettableFuture<String> stringFuture = SettableFuture.create();

// Inside run()
// This will block your thread until stringFuture is set, or until the given timeout has expired.
final String string = stringFuture.get(1, TimeUnit.MINUTES);

// Outside run()
public void setStr(final String s) {
    stringFuture.set(s);
}