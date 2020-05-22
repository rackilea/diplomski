public void doStuff(String param){
  try {
    process(param);
  } catch(RuntimeException e) {
    throw new RuntimeException("Something weird happened while processing " + param, e);
  }
}

private void process(String value){
  throw new IllegalStateException("Not implemented yet!");
}