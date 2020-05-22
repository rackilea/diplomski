List<Boolean> results = futures.stream().map(booleanFuture -> {
    try
    {
        return booleanFuture.get();
    }
    catch (InterruptedException | ExecutionException e)
    {
        throw new RuntimeException(e);
    }
}).collect(Collectors.toList());