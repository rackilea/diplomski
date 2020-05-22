public class x extends Service {

//Code for your service goes here

   public talk() {
      Intent i = new Intent();
      i.putExtras("Extra data name", "Super secret data");
      i.setAction("FILTER");
      sendBroadcast(i);
   }
}