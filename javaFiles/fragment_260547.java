@Override
public void run() {
    isRunning = true;

    while(isRunning){
        //do stuff
        synchronized(fastQQueue1){
            if(fastQQueue1.remainingCapacity() == 0){ //empty queues - 5000 record pairs at a time

                synchronized (fastQQueue1){
                    synchronized (fastQQueue2){
                        emptyQueues();
                    }
                }
            }
        }
    }
}