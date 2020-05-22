public class Value implements Comparable<Value> {

    int item;
    boolean isPrime;

    public Value(int item, boolean isPrime) {
        this.item = item;
        this.isPrime = isPrime;
    }

    @Override
    public int compareTo(Value o) {
        if (o == null) {
            return 1;
        }
        return this.item - o.item;
    }

    @Override
    public String toString() {
        return "Value{" + "item=" + item + ", isPrime=" + isPrime + '}';
    }
}