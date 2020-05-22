{
    try{
      return future.get();
    }
    catch (InterruptedException | ExecutionException e){
      e.printStackTrace();
      throw new RuntimeException(e)
    }
}