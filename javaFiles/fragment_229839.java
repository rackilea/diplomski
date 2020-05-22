Class<? extends Thread> clazz = (Class<? extends Thread>) Class.forName(testName);
Thread[] threads = new Thread[nrThreads];
for ( int i = 0; i < nrThreads; i++ ) {
    threads[i] = clazz.newInstance();
    threads[i].start();
}