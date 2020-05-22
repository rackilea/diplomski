} catch (InterruptedException e) {
    pool.shutdownNow(); //cancels the tasks
    //restore interrupted flag and exit
    Thread.currentThread.interrupt();
    //or rethrow the exception
    throw e;
}