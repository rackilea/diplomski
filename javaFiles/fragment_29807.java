public class Queue<T extends Comparable<T> > {

    private int front;
    private int rear;
    private Comparable[] items;
    private int maxQue;
    private static final int MAX_ITEMS = 1000;

    public Queue() {
        maxQue = MAX_ITEMS + 1;
        front = maxQue - 1;
        rear = maxQue - 1;

        items = new Comparable[maxQue];
    }
}