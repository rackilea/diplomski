public void println(String x) {
    synchronized(this) {
        this.print(x);
        this.newLine();
    }
}