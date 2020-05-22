void send(String message) {
    synchronized (queue) {
        queue.put(message);
        System.out.println("SIZE: " + queue.size());
    }
}