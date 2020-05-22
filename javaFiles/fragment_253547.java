ParallelSender parallelSender = new ParallelSender();
Callable<Integer> integerCallable = new Callable<Integer>(){

    @Override
    public Integer call() throws Exception{
        return Integer.valueOf(1);
    }
};
Integer result = parallelSender.getResult(integerCallable);