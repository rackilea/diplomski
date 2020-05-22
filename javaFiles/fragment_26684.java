public void listen() {
    BlockingQueue queue = new SynchronousQueue();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, Session.getMaxSessionCount(), 100, TimeUnit.SECONDS, queue);
    while (true) {
        try {
            queue.submit(new Session(database, serverSocket.accept()));
        } catch (IOException ex) { 
            ex.printStackTrace();
        }
    }
}