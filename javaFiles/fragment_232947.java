boolean result = futures.stream().allMatch(booleanFuture -> {
    try
    {
        return booleanFuture.get();
    }
    catch (InterruptedException | ExecutionException e)
    {
        throw new RuntimeException(e);
    }
});