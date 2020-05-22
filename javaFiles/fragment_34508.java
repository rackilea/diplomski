someMethod() {
    // prevent GUI from freezing using threads
    final Runnable r = new Runnable() {
        public void run() {
            status = new StatusFrame();
        }
    };
    SwingUtilities.invokeLater(r);

//do something 
    status.update("process 1 completed");
//do something else
    status.updateStatus("Process 2 completed");