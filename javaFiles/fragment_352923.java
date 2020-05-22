public class AndroidLiB {
  Activity activity;
  AndroidLiB(Activity activity){ 
        this.activity = activity;
   }


  public void startGPS()
  {
    Toast.makeText(activity,"Your GPS started",Toast.LENGTH_LONG).show();
  }

 }