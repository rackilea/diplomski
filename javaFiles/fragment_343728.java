Thread t1 = new Thread(() -> ...
Thread t2 = new Thread(() -> ...
t1.start();
t2.start();

t1.join();
t2.join();
out.close();