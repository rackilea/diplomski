import java.util.Arrays;

public class PriorityQueue
{
    private int[][] queueArray;

    public PriorityQueue() // constructor
    {
        queueArray = new int[3][5];
    }

    public void printQueue()
    {
        System.out.println(Arrays.toString(queueArray));
    }

    public boolean isFull(int[] array)
    {
        return findEmptySlot(array) < 0;
    }

    public boolean enqueue(int item)
    {
        if (item < 1 || item > 299) {
            throw new IllegalArgumentException("item must be between 1 and 299");
        }
        for (int i = item / 100; i < this.queueArray.length; i++) {
            if (enqueue(item, this.queueArray[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean enqueue(int item, int[] queue) {
        int emptySlot = findEmptySlot(queue);
        if (emptySlot >= 0) {
            queue[emptySlot] = item;
            return true;
        }
        return false;
    }

    private int findEmptySlot(int[] queue) {
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}