// interrupt and wait until thread actually finishes
snake.thread.interrupt();
snake.thread.join();

// change the destination
snake.destination = newDestination;

// restart the thread
snake.thread = new Thread(snake);
snake.thread.start();