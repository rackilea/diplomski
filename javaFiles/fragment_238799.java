ThreadTask task = new ThreadTask(); 
Thread t = new Thread(task);
t.start();
...
task.stopTask();
t.join();