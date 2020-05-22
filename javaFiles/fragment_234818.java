for(Future future : taskList){
    try{
        future.get(30, TimeUnit.SECONDS);
    }catch(TimeoutException ex) {
        future.cancel(true);
    }
}