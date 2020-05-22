titanGraph = TitanFunctions.getTitanGraph();
traversalSource = titanGraph.traversal();
Runnable r = new Runnable() {
    public void run() {
        synchronized(titanGraph){
            long ab = traversalSource.V().has("RequestJob", "RequestId", 203)
                .has("JobLockStatus","F")
                .property("JobLockStatus", "B").count().next();
            titanGraph.tx().commit();
        }    
    }
};
Thread t1 = new Thread(r, "T1");
Thread t2 = new Thread(r, "T2");
t1.start();
t2.start();