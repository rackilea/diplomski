public void Start() {
    Runnable task = () -> {
        try {
            /* SETUP NATIVE LIBRARY */
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (keepRunning) {
            while (!myQueue.isEmpty()) {
                Process_Run();
            }
            try {
                Thread.sleep(20);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        myThread = new Thread(task); // Run the task in a background thread
        myThread.setDaemon(true); // Terminate the running thread if the application exits
        myThread.start(); // Start the thread
    }

private void Process_Run() {
    try {
        MyCustomData myData = myQueue.take();
        /*  DO STUFF  */
    } catch (Exception e) {
        e.printStackTrace();
    }
}