public void doStuff(String param){
  try {
    process(param);
  } catch(RuntimeException e) {
    logger.error("Something weird happened while processing " + param, e);
    throw e;
  }
}