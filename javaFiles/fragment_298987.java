public void addMessage(String message) {
     synchronized(inputQueue) {
          inputQueue.offer(r);
          inputQueue.notify();
     }
}