List<Thread> threads = new ArrayList<Thread>();
for(int x = 0; x <  noOfThreads; x++){
    Thread t = new Thread(/* ... */);
    threads.add(t);
    // do something with t
}