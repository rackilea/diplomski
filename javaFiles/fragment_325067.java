List<Thread> allThreads = new ArrayList<>();

for (int i = 0; i < 100; i++) {
  Thread t1 = new Thread(tg1, runnable, i + "");
        t1.start();
   allThreads.add(t1);  
}

allThreads.forEach(Thread::join);