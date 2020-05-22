Thread[] threads = new PrimeFinderThread[numberThreads];
for (int i = 0; i < numberThreads; i++) {
    threads[i] = new PrimeFinderThread (lowerBoundary, interval);
    threads[i].setName("prime" + i);
    threads[i].start();
}