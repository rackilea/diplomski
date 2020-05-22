CompletableFuture.runAsync(() -> {
      List<Integer> integerList = new ArrayList<>();
      integerList.get(1);    // throws exception
    }).thenRun(() -> {
      System.out.println("No exception occurred");
    });