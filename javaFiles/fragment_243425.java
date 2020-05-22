try {
  // Do something
  if (somethingIsWrong) {
    throw new MyException("This is broke, yo!");
  }
} catch(MyException me) {
  // Write code to handle the exception or log it...
}