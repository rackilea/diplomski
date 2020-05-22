public Item get(int id) {
    BlockingQueue<Item> queue = new ArrayBlockingQueue<Item>(1);
    for(Worker w : workers) {
        w.get(id, queue); // Several threads start reading that item from data sources
    }
    return queue.take();
}