Runnable r1 = new Runnable() { public void run() { /* this is r1 */ } };
Runnable r2 = new Runnable() { public void run() { /* this is r2 */ } };
Thread t1 = new Thread(r1);
Thread t2 = new Thread(r2);
t1.start();
t2.start();