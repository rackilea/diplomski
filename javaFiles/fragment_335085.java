Callable<String> task = () -> {
    ...
  };

   public Future<String> myMethod() {
     return Executors.submit(task);
   }

   public String fallBackMethod() {
      ...
   }

   String value = null;
   try {
      Future<String> result = myMethod.get(1, TimeUnit.SECONDS);
      value = result.get();
   } catch (TimeoutException e) {
      value = fallBackMethod();
   }