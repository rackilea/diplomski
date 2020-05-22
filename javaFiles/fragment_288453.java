Object monitor = new Object();

void recursiveMethod() {
   // do stuff and then wait...
   synchronized (monitor) {
      monitor.wait();
   }
}

void doClick() {
   synchronized (monitor) {
      monitor.notify();
   }
}