Integer a,b,c;
if (a == b) {
  // a and b refer to the same instance.
  // for small integers where a and b are constructed with the same values,
  // the JVM uses a factory and this will mostly work
  //
  // for large integers where a and b are constructed with the same values,
  // you could get a == b to fail
}