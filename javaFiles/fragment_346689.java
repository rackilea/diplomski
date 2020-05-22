class ShutdownHook extends Thread
{
    public void run()
    {
        // perform shutdown actions
    }
}

// Then, somewhere in your code

Runtime.getRuntime().addShutdownHook(new ShutdownHook())