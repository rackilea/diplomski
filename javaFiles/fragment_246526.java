try {
  methodThrowingIOException();
} catch (FileNotFoundException e) {
  doSomething();
} catch (IOException e) {
  doSomethingElse();
}