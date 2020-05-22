Thread watchThread = new Thread(new WatchRunnable());
watchThread.start();
// ...
// when the main thread wants the program to stop, it just interrupts the thread
watchThread.interrupt();
// although not necessary, main thread may wait for the watch-thread to finish
watchThread.join();