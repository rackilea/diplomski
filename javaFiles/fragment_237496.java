public int onStartCommand(Intent intent, int flags, int startId){
    try{
        commitToFile("Start");
    }catch (Exception e){}
    try{
        commitToFile("End");
    }catch (Exception e){}
    return START_NOT_STICKY;
}