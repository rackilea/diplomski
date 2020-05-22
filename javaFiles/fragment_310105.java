final List<Process> processes = new ArrayList<Process>();

// start processes
for (...) {
   p = ...
   processes.add(p);
}

// create and start "watchdog" thread
new Thread() {
   public void run() {
      for (p: processes) 
         p.waitFor();

      // at this point all processes are terminated
   }.start();

// ok, I've started the "watchdog" thread. now let's do fun stuff...

// do my stuff...