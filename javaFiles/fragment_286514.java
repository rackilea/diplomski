private void onUserSubmittedPin(String pin) {
     synchronized(LOCK) {
         this.pin = pin;
         dialogIsShowing = false;
         LOCK.notifyAll();
     }
}