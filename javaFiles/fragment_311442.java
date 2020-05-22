public void serialize (Object[] xxx){
  serialize (Arrays.asList(xxx));
}

public void serialize (Iterable xxx){
  for (Object x: xxx) {
     x.doSomething()
  }
}