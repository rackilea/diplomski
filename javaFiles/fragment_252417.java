final BlockingQueue<Message> q = new LinkedBlockingQueue<Message>();
// start all the worker threads,
// making them report progress by adding Messages into the queue
for (...) {
  threadManager.submit(new Runnable() {
    // initialize the worker
    q.offer(new Message("10% completed"));
    // do half of the work
    q.offer(new Message("50% completed"));
    // do the rest of the work
    q.offer(new Message("100% completed"));
  });
}
// after starting all the workers, call a blocking retrieval method
// on the queue, waiting for the messages
while (!(everything is done)) {
  Message m = q.take();
  // process the message
}