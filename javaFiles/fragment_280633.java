public static void addToResults(ResultsEntry newResult, int turn)
{   
    Integer resultsCount =  newResult.getCount();
    char resultsTarget = newResult.getTarget();
    Thread thread = Thread.currentThread();

    /*
     * Turn number is compared to the size of the results array to control the
     * order of execution. 
     */
    synchronized (LOCK){
        while (turn != results.size()){
            try {
                System.out.println(thread.getName() + " is waiting");
                LOCK.wait();
                } catch (InterruptedException e) {}
        }
            System.out.println(thread.getName() + " is adding " + newResult);
            SharedResults input = new SharedResults(resultsCount, resultsTarget);
            System.out.println("Cumulative Results are " + results);    
            LOCK.notifyAll();   
        }
        }