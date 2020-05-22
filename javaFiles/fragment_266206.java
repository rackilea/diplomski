class PrintStream extends FilterOutputStream implements Appendable, Closeable {
    //...

    public PrintStream printf(String var1, Object... var2) {
        return this.format(var1, var2);
    }

    public PrintStream format(String var1, Object... var2) {
        //...
        return this; // <-- here
    }
    //...
}