public class MyActivity {

private Handler handler;

private void onCreate() {

   handler = new Handler() {

      @Override
      public void handleMessage(Message msg) {
         pd.dismiss();
         stepTwo();
      }
   };

   final ProgressDialog dialog = ProgressDialog.show(this, "Please wait..", "Doing stuff..", true);
   Thread t = new MyThread() {
   t.start():

}

private class MyThread extends Thread() {
   public void run() {
      //do some serious stuff...
      handler.sendEmptyMessage(0);       
   }
}   

}