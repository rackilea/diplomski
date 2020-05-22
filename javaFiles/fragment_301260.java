final void runWorker(Worker w) {
  // ... snip
     beforeExecute(wt, task);
     try {
           task.run();
     } 
     ...
     } finally {
        afterExecute(task, thrown);
     }

   // ... snip
}