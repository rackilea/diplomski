Integer result = stream
    .map(future -> {
        try {
          return future.get();
        } catch (InterruptedException | ExecutionException e) {
        }
        return null; })
    .filter(Objects::nonNull)
    .reduce(sum)
    .orElse(0);