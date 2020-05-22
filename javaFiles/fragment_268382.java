for (Future f :futureList)
 {
  response.add(f.get());
  }

//shuttingdown the Executor
executor.shutdown();