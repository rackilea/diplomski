synchronized (obj) {
  while (<condition does not hold> and <timeout not exceeded>) {
    long timeoutMillis = ... ; // recompute timeout values
    int nanos = ... ;
    obj.wait(timeoutMillis, nanos);
  }
  ... // Perform action appropriate to condition or timeout
}