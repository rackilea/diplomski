public void runJob(){
    boolean jobDone = false; 
    if(!myJobInQueue.isEmpty() && myDuration > myPendingTime){
         myDuration-= myPendingTime;
         myFinishedJobs.add(myJobInQueue.get(0));
         myJobInQueue.remove(0);
         System.out.println("The job runing is : "+ myJobInQueue.get(0));
        jobDone=true;
    }
    if(!jobDone ){
         runJob();
    } 
  }