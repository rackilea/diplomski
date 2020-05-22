final Object lock = new Object();

timer.scheduleAtFixedRate(new TimerTask() { ... 

   if(stop) { synchronized(lock) { lock.notify(); }} // let test know that we're done
});

synchronized(lock) { lock.wait(); } // wait for timer to finish