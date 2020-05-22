Object aMonitor = new Object();

synchronized(aMonitor) {
   a = 55;
   aMonitor.wait();
}