public <E> void take(BlockingQueue<E> queue, List<E> to, int max) 
        throws InterruptedException {

    for (int i = 0; i < max; i++)
        to.add(queue.take());
}