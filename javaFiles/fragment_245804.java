ArrayList<Thread> allThreads = new ArrayList<>(); // create a list of all Threads
for(int i=1;i<=totalNumberOfUsers;i++) {
    t=new Thread(new CasLoadTest());
    allThreads.add(t); // add new Thread to list
    ...
}
...
// wait for all Threads to end before executing next code
for(Thread thread : allThreads)
    thread.join();