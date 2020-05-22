if (numberOfWorkingThreads < corePoolSize) {
   startNewThreadAndRunTask();
} else if (workQueue.offer(task)) {
   if (numberOfWorkingThreads == 0) {
       startNewThreadAndRunTask();
   }
} else if (numberOfWorkingThreads < maxPoolSize)
    startNewThreadAndRunTask();
} else {
    rejectTask();
}