Thread t1 = new Thread(spider1);
Thread t2 = new Thread(spider2);
t1.start();
t2.start();
t1.join();
t2.join();