public static class EntryManager
{
    private int inFoo = 0;
    private int inBar = 0;
    private Queue<Thread> queue = new LinkedList<>();

    public synchronized void enterBar(Thread t) throws InterruptedException
    {
        // Place the Thread on the queue
        queue.add(t);

        while(queue.peek() != t)
        {
            // Wait until the passed Thread is at the head of the queue.
            this.wait();
        }

        while(inFoo > 0)
        {
            // Wait until there is no one in foo().
            this.wait();
        }
        // There is no one in foo.  So this thread can enter bar.
        // Remove the thread from the queue.
        queue.remove();         
        inBar++;    
        // Wakeup everyone.
        this.notifyAll();
    }

    public synchronized void enterFoo(Thread t) throws InterruptedException
    {
        // Place the thread on the queue
        queue.add(t);

        while(queue.peek() != t)
        {
            // Wait until the passed Thread is at the head of the queue.
            this.wait();
        }

        while(inBar > 0)
        {
            this.wait();
        }
        // There is no one in bar.  So this thread can enter foo.
        // Remove the thread from the queue.
        queue.remove(); 
        inFoo++;
        // Wakeup everyone.
        this.notifyAll();
    }

    public synchronized void exitBar()
    {
        inBar--;
        // Wakeup everyone.
        this.notifyAll();
    }

    public synchronized void exitFoo()
    {
        inFoo--;
        // Wakeup everyone.
        this.notifyAll();
    }
}