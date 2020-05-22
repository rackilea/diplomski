synchronized(LOCK) {
     if(pin == null && !dialogIsShowing) {
         dialogIsShowing = true;
         callSerially(() -> promptForPin());
     }
     while(pin == null) {
         LOCK.wait();
     }
}