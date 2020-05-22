public class AscTaskLogin extends AsyncTask<String, Void, Boolean> {

 LoginActivity mActivity;

 public AscTaskLogin(Activity activity) {
    this.mActivity = activity;
 }

 @Override
 protected Boolean doInBackground(String... params) {
     boolean result;

     //do some stuff

     return result;
 }

 @Override
 protected void onPostExecute(Boolean result) {        
        Intent i= new Intent();
        i.setClass(mActivity, Copy.class);  
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
        mActivity.startActivity(i);       
 }
}