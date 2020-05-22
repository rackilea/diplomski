/**  keep track of currently running tasks */
Vector runningTasks<Future> = new Vector<Future>();

public void run(){
  for (ScheduledCampaigns campaign : scheduledCampaignsList) {

    String cmpName = "SCH_CAMPAIGNS_" + campaign.getCampaign_id();

    Future f = execService.submit(new Runnable() {
        public void run() {
            smppService.submitShortMessage(campaign);
        }
    });
    runningTasks.add(f);

  }//EO For Loop

  // which tasks have just completed?
  Vector<Future> justCompletedTasks = new Vector<Future>();

  // check currently executing tasks
  for (Future task : runningTasks){
   if( task.isDone() || tasks.isCancelled() ){
      justCompletedTasks.add(task);
   }
  } // EO check executing tasks

  // remove completed tasks from current list
  runningTasks.removeAll(justCompletedTasks);
} // EO run