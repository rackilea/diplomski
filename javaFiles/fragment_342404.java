for (int ii=0; ii<NUM_EVENTS; ++ii) {
  synchronized( monitor) {
    monitor.add(cnt);
  }
  synchronized(cnt) {
    cnt++;              // <-- why does moving the synchronized block here result in cnt being wrong?
  }
}