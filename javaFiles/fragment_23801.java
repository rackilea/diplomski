class Fib {
    private int previous;
    private int current;

    public Fib(int start1, int start2) {
        this.previous = start1;
        this.current = start2;
    }

    public int next() {
        int temp = previous + current;
        previous = current;
        current = successor;
        return current;
    }
}