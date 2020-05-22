ListenableFuture<Integer> countFuture = getNbFoo();
return countFuture.transformAsync(
    count -> {
      List<ListenableFuture<Foo>> results = new ArrayList<>();
      ListenableFuture<?> previous = countFuture;
      for (int i = 0; i < count; i++) {
        final int index = i;
        ListenableFuture<Foo> current = previous.transformAsync(
            unused -> getFoo(index),
            directExecutor());
        results.add(current);
        previous = current;
      }
      return allAsList(results);
    },
    directExecutor());