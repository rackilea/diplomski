public void println(int x) {
    synchronized (lock) {
        print(x);
        println();
    }
}