ArrayBlockingQueue queue = null;

try (ObjectInputStream in = new ObjectInputStream (
        new FileInputStream("queue.data"))) {
    queue = in.readObject()
}