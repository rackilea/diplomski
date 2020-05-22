public void testMethod(){

    int exceptions = 0;

    List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
    List<CompletableFuture<Integer>> cfList = new ArrayList<>();

    for(int number : numbersList){
        CompletableFuture<Integer> cf = methodWithFuture(number);
        cfList.add(cf);
    }

    CompletableFuture<Void> allOfCF = CompletableFuture.allOf(cfList.toArray(new CompletableFuture[0]));       
    try {allOf.get();} catch (InterruptedException | ExecutionException ignored) {}

    int sum = 0;
    for(CompletableFuture<Integer> cf : cfList){
        if(cf.isCompletedExceptionally()){
            exceptions ++;
        } else {
            sum += cf.get();
        }
    }

    System.out.println("Number of times the addNumber method threw an exception=" + exceptions);
    System.out.println("SUM " + sum);
}


public CompletableFuture<Integer> methodWithFuture(int number) {
    return CompletableFuture.supplyAsync(() -> addNumber(number));
}