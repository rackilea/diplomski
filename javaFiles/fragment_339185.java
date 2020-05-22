import java.util.concurrent.BlockingQueue;

public class NumberGenerator implements Runnable {
    private final int biggestNumberToCheck;
    private final BlockingQueue<Integer> candidateQueue;
    private final int smallestNumberStart;

    public NumberGenerator(int smallest, int biggest,
            BlockingQueue<Integer> queue) {
        biggestNumberToCheck = biggest;
        candidateQueue = queue;
        smallestNumberStart = smallest;
    }

    public void run() {
        for (int i = smallestNumberStart; i <= biggestNumberToCheck; i++) {
            candidateQueue.add(i);
        }

    }
}