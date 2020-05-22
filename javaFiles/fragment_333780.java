public class NumberWords {
    private int totalWordCount;
    private int activeThreads;


    public synchronized void incTotalWordCount(int n) {
        totalWordCount += n;
        activeThreads--;
        System.out.println("The total word count is " + totalWordCount);
    }

    public synchronized void printCount() {
        System.out.println("The total word count(print count) is " + totalWordCount);
    }

    public int getActiveThreads() {
        return activeThreads;
    }

    public void setActiveThreads(int activeThreads) {
        this.activeThreads = activeThreads;
    }
}