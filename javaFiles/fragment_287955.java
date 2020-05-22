void threadloop()
{
    while (!quit)
    {
        Callable<T> item = null;
        synchronized (workQueue)
        {
            if (workQueue.Count == 0)
                workQueue.wait();

            // we could have been woken up for some other reason so check again
            if (workQueue.Count > 0)
                item = workQueue.pop();
        }
        if (item != null)
             item.Call();
    }
}