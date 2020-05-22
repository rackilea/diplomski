void checkThread() {

 if (mThread != Thread.currentThread()) {

  throw new CalledFromWrongThreadException( "Only the original thread that created a view hierarchy can touch its views.");

}