try {
    List<Future<String>> resultList=executor.invokeAll(list);
    for(Future<String> f:resultList){
        try{
            System.out.println(f.get());
        }catch (ExecutionException e) {
            System.out.println("HELLO SOME ERROR: " + e.getMessage());
        }
} catch (InterruptedException e) {
    e.printStackTrace();
}