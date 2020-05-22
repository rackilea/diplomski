someMethod() {
    // prevent GUI from freezing using threads
    final Runnable r = new Runnable() {
        public void run() {
            status = new StatusFrame();
        }
    };
    new Thread(r).start();

// inside the StatusFrame
//do something 
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            update("process 1 completed");
        }
    );

 //do something else sometime later
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
             update("Process 2 completed");
        }
    );