for (int ii=0; ii<NUM_EVENTS; ++ii) {
  synchronized( monitor) {
    synchronized(cnt) {        // <-- is this synchronized necessary?
      monitor.add(cnt);
    }
    synchronized(cnt) {
      cnt++;        // <-- why does moving the synchronized block to here result in the correct value for cnt?
    }
}