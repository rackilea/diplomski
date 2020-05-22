//Give you set of Threads
Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();

//Iterate over set to find yours
for(Thread thread : setOfThread){
    if(thread.getId()==yourThread.getId()){
        thread.interrupt();
    }
}