public class CounterAndNotifier
{
    private int counter = 0;
    private int count;
    private Runnable runnable;

    public CounterAndNotifier(int count, Runnable runnable)
    {
        this.count = count;
        this.runnable = runnable;
    }

    public synchronized void incrementCounter()
    {
        counter++;
        if (counter == count) {
            runnable.run();
        }
    }
}