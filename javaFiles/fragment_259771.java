// TODO: Rename NuThread to something more suitable :)
NuThread runnable = new NuThread();
Thread t1 = new Thread(runnable);
Thread t2 = new Thread(runnable);
Thread t3 = new Thread(runnable);
t1.start();
t2.start();
t3.start();