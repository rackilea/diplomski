try {
  doStuff();
} catch(ArithmeticException e) {
  System.err.println("Arithmetic exception caught:");
  e.printStackTrace(System.err);
}