try{
   future.get(timeout, unit);
}catch(TimeoutException e){
    //task will be cancelled below
}catch(ExecutionException e){
    //exception thrown in task; rethrow
    //... throw new MyWrappedException(e.getCause());
}finally{
    //Harmless if task already completed
    future.cancel(true); //interrupt if still running
}