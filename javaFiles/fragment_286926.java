Semaphore runningTasksSema=new Semaphore(maxNumberOfRunningTasks);
EventCounter  eventCounter =new EventCounter ();

for( final String item : fetchItems() ) {
    final Runnable task = new Runnable() {
       public void run() {
            processItem( item ); 
            runningTasksSema.release();
            eventCounter.up();
       }
    };
   runningTasksSema.aquire();
   executor.execute(task);
}