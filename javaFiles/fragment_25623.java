boolean methodExists = false;
try {
  obj.doSomething("", null);
  methodExists = true;
} catch (NoSuchMethodError e) {
  // ignore
}