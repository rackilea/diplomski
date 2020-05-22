DBObject query = ... // your definition is probably non blocking

vertx.executeBlocking(future -> {
  // Call blocking API that takes a significant amount of time to return
  Artist result = findQuery.get();
  future.complete(result);
}, res -> {
  System.out.println("The artist is: " + res.result());
});