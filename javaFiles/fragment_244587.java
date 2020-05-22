// Run while not interrupted.
while(!(Thread.interrupted())
{
    try
    {
        // Do whatever here.
    }
    catch(InterruptedException e)
    {
        // This will cause the current thread's interrupt flag to be set.
        Thread.currentThread().interrupt();
    }
}

// Perform cleanup and exit thread.