static void main(String[] args) {
    List<Deque<Integer>> publishQueues = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        new Thread(new Worker(i, publishQueues)).start();
    }
}

class Worker implements Runnable {
    Deque subscriberQueue;
    List<Deque<Integer>> publishQueues;
    int i;
    Worker(int i, List<Deque<Integer>> publishQueues) {
        this.i = i;
        this.publishQueues = publishQueues;
        this.subscriberQueue = new ConcurrentLinkedDeque<>();
        this.publishQueues.add(this.subscriberQueue);
    }

    void Run() {
        LinkedList<Integer> ints = new LinkedList<>();
        for (int j = i; j <= 100; j+=10) {
            ints.add(j);
        }

        while (true) {
            Integer publishedInteger = subscriberQueue.poll();
            if (publishedInteger == ints.getFirst() - 1) {
                Integer integer = ints.poll();
                System.out.println(integer);
                for (Dequeu<Integer> publishQueue : publishQueues) {
                    publishQueue.addLast(integer);
                }
            }
        }
    }
}