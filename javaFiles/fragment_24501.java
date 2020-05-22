private boolean isLastImportDataTaskFinished;

@Scheduled(fixedDelay = 300000)
 public void importDataTaskManager(){
    if (isLastImportDataTaskFinished()){
        new Thread(new ImportantDataProcessing())).start();           
    }
    else{
        // log the problem if you want
    }
}

 private isLastImportDataTaskFinished(){
   // to retrieve this information, you can do as you want : use a variable 
   //  in this class or a data in database,file...
   // here a simple implementation 
   return isLastImportDataTaskFinished;
 }