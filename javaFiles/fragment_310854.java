public class y extends Activity {

   //Code for your activity goes here

   BroadcastReceiver br = new BroadcastReceiver() {
      public void onReceive(Intent i) {
         String str = (String) i.getExtras().get("Extra data name").toString();
      }

   OnResume() {
      super.OnResume();
      IntentFilter filt = new IntentFilter("FILTER");
      this.registerReceiver(br, filt);

      //Do your other stuff
   }

   OnPause() {
      super.OnPause();
      unregisterReceiver(br);
   }