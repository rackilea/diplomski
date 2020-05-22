private final BlockingQueue<String> linesQueue = ...

public void displayLine(String line) {
     linesQueue.add(line);
}

// somewhere else, in another thread.
String line = linesQueue.take(); // wait for a line.

String line = linesQueue.poll(); // get the next or null