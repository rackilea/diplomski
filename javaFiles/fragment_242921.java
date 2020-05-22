class MyBackgroundWorker extends Worker {
  public MyBackgroundWorker(Context context, WorkParameters workParameters){
     super(context, workParameters);
   }

  @Override
  Result doWork(){
    //make room request here
    //after selection is successful schedule your alarm manager notification here
  }
}