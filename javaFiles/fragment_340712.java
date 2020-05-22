public void method() {
  try {
     int number;
     number = parseInt(this.something);
    //more code
  } catch (NumberFormatException e) {
    // log exception
    // do things to recover from the error if possible
    // maybe rethrow `e` or throw another exception
  }
  // avoid to write some code here, usually it is wrong.
}