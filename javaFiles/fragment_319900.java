public class CircularStack {

    int size = 5;
    int[] arr = new int[size];
    int top = 0;

    public void push(int i) {
        arr[top++ % size] = i;
    }

    public int pop() {
        return arr[--top % size];
    }
}