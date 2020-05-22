Threads R1 = new Threads("Thread 1");
Thread thread = new Thread(R1);
thread.start();

Thread.sleep(1000);
R1.setoff();