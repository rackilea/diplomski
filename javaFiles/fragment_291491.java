/* It creates and starts thread Thread 2 */
synchronized (thread2) {
  if (!thread2.taskCompleted)
    thread2.wait();
}
/* continue execution... */