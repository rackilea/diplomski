MyClass c = new MyClass();

Runnable runnable = c::isMyAttribute;

Thread thread1 = new Thread(runnable, "t1");
Thread thread2 = new Thread(runnable, "t2");
Thread thread3 = new Thread(runnable, "t3");

thread1.start();
thread2.start();
thread3.start();

thread1.join();
thread2.join();
thread3.join();

System.out.println(c.getThreadsSet());