List<Thread> threads = new List<Thread>();
for(int i=0;i<200;i++){
    Thread myThread = new Thread(runnableInstance);
    myThread.start();
    threads.add(myThread);
}
//All threads are running
for(Thread t : threads) {
    t.join();
}
//All threads are done