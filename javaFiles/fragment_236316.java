Thread thread1 = new Thread(()-> test3(dataset));
    thread1.start();
    Thread thread2 = new Thread(()-> test2(dataset));
    thread2.start();
    Thread thread3 = new Thread(()-> test1(dataset));
    thread3.start();

    thread1.join();
    thread2.join();
    thread3.join();