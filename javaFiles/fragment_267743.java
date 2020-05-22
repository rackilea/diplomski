Thread producer = new Thread(new ProducerThread(f), "Producer");
    producer.start();
    ArrayList<Thread> workers = new ArrayList<Thread>();
    for (int i=0; i<num_threads; i++) {
        workers.add(new Thread(new WorkerThread(dict, factory), "Worker"));
    }
    for (Thread t : workers) {
        t.start();
    }
    try {
        producer.join();
        for (Thread t : workers) {
            t.join();
        }
    } catch (InterruptedException e) {
        System.out.println("Main thread interrupted...");
    }