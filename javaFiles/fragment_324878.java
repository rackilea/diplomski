try {
    Boolean result = Tasks.await(tcsTask);
}catch(ExecutionException e){
    //handle exception 
}catch (InterruptedException e){
    //handle exception
}