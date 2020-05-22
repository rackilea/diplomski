robotWaitTask waitingTask = new robotWaitTask(1000);
waitingTask.start(); //start a new thread, and the object is blocked in a separate thread
//this line will print as soon as the previous line called even before 1000ms
System.out.println("here)"; 


robotWaitTask waitingTask = new robotWaitTask(1000);
waitingTask.run();
//this line will print after 1000ms because the object is blocked in this thread
System.out.println("here)";