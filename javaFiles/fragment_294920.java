//Some webservice method (synchronous)
public Result process(Blah blah){
    try{
        return getResult(TimeUnit.SECONDS, 10);
    }catch(InterruptedException e){
        //No result within 10 seconds!
        throw new ServiceUnavailableException("blah");
    }
}