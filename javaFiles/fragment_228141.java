public class Jump {
    int count;
    int from;
    int to;

    public Jump(int count, int from, int to) {
        this.count = count;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "" + count + " frog/s jump from " + from + " to " + to;
    }
}