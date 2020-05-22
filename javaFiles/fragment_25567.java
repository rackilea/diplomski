ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("queue.data"))) {
    out.writeObject(queue);
}