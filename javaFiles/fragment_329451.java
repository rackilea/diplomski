public static void main(String args[]) throws InterruptedException {
    Deque<Integer> deque = new LinkedList<Integer>();
    InsertingThread it = new InsertingThread(deque);
    ReadingThread1 rt = new ReadingThread1(deque);
    it.start();
    it.join();
    rt.start();
}