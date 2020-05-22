BlockingQueue<String[]> queue = new LinkedBlockingQueue<String[]>();
 ...

 // inside of run, producer passes the queue into the PingNode
 public void run() {
     pool.submit(new PingNode(queue));
 }

 // consumer
 while (true) {
     String[] array = queue.take();
     ...
 }