ConcurrentHashMap<String, Year> concurrentMap;

final Object lock = new Object();

public void runAnalysis(final ConcurrentHashMap map) {
    /*synchronized (map) {
        //This will cause addValue() to lock up while the analysis is running
    }*/

    synchronized (lock) {
        //Now we can run a long-running analysis and not block the addValue() method

        //Additionally, if another thread calls runAnalysis(), it must wait to 
        //get our lock (when a current running analysis is completed) 
        //before it can start
    }

}

//This method needs access to concurrentMap, so we can't lock it
public void addValue() {
    concurrentMap.add("key", new Year());
}