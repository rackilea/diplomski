Thread t = new Thread(new Runnable() {
    public void run() {
       // Do interesting background tasks, probably in a while(running) loop.
    }
});

// This next line is the answer to your question
t.setDaemon(true);

t.start();