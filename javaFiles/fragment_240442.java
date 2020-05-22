class $$lambda$xy implements Consumer<Object> {
    private PrintStream out;

    $$lambda$xy(PrintStream out) {
        this.out = out;
    }

    void accept(Object o) {
        out.println(o);
    }
}