class CompositeException extends Exception {
    private final List<Exception> es;

    public CompositeException(Exception[] es) {
        this.es = Arrays.asList(es);
    }

    public CompositeException(List<Exception> es) {
        this.es = new ArrayList<Exception>(es);
    }

    @Override
    public void printStackTrace(PrintStream s) {
        for (Throwable e : this.es) {
            e.printStackTrace(s);
        }
    }
}