CompletableFuture<Void> setup = new CompletableFuture<>();
delayedFunction(setup);

//do whatever you want
System.out.println("foo");

//once you are ready, complete setup to execute the delayed function
setup.complete(null);


public static CompletableFuture<Void> delayedFunction(CompletableFuture<Void> setup) {
  return setup.
    thenAccept(v-> {
      System.out.println("bar");
    });
}